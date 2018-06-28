package com.indiya.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.indiya.member.dto.MemberDto;
import com.indiya.member.dto.ZipDto;
import com.indiya.member.service.MemberService;
import com.indiya.member.service.MemberServiceImpl;
import com.indiya.util.PageMove;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService;
	
	public void init() {
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		System.out.println("act ==== " + act);
		
		if("mvjoin".equals(act)) {
			PageMove.redirect(request, response, "/join/member.jsp");
		} else if("mvlogin".equals(act)) {
			PageMove.redirect(request, response, "/login/login.jsp");
		} else if("idsearch".equals(act)) {
			String id = request.getParameter("id");
			System.out.println("검색 아이디 : " + id);
			int cnt = memberService.idCheck(id);
			System.out.println("검색 아이디 갯수 : " + cnt);
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(cnt);
		
		} else if("mvzip".equals(act)) {
			PageMove.redirect(request, response, "/join/zipsearch.jsp");
		} else if("zipsearch".equals(act)) {
			String dong = request.getParameter("dong");
			System.out.println("검색 동이름 : " + dong);
			List<ZipDto> list = memberService.zipSearch(dong);
			System.out.println("검색동 갯수 : " + list.size());
			request.setAttribute("zipList", list);
			request.setAttribute("searchDong", dong);
			
			PageMove.forward(request, response, "/join/zipsearch.jsp");
		} else if("register".equals(act)) {
			MemberDto memberDto = new MemberDto();
			memberDto.setId(request.getParameter("id"));
			memberDto.setName(request.getParameter("name"));
			memberDto.setPass(request.getParameter("pass"));
			memberDto.setEmail1(request.getParameter("email1"));
			memberDto.setEmail2(request.getParameter("email2"));
			memberDto.setTel1(request.getParameter("tel1"));
			memberDto.setTel2(request.getParameter("tel2"));
			memberDto.setTel3(request.getParameter("tel3"));
			memberDto.setZipcode(request.getParameter("zipcode"));
			memberDto.setAddr1(request.getParameter("addr1"));
			memberDto.setAddr2(request.getParameter("addr2"));
			
			int cnt = memberService.registerMember(memberDto);
			if(cnt != 0) {//성공.
				request.setAttribute("userInfo", memberDto);
			
				PageMove.forward(request, response, "/join/registerok.jsp");
			} else {
				PageMove.redirect(request, response, "/join/registerfail.jsp");
			}
			
		} else if("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			MemberDto memberDto = memberService.login(id, pass);
			if(memberDto != null) {
				
				/////////////////////////// Cookie /////////////////////////////
				if("saveok".equals(request.getParameter("idsave"))) {
					System.out.println("아이디 저장한다.");
					Cookie cookie = new Cookie("loginid", id);
					cookie.setPath(root);
					cookie.setMaxAge(60*60*24*365*10);
					
					response.addCookie(cookie);
				} else {
					Cookie cookie[] = request.getCookies();
					if(cookie != null) {
						int len = cookie.length;
						for(int i=0;i<len;i++) {
							if("loginid".equals(cookie[i].getName())) {
								cookie[i].setMaxAge(0);
								cookie[i].setPath(root);
								
								response.addCookie(cookie[i]);
								break;
							}
						}
					}
				}
				////////////////////////////////////////////////////////////////
				
				///////////////////////// session //////////////////////////////
				
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				
				////////////////////////////////////////////////////////////////
//				request.setAttribute("userInfo", memberDto);
				
				PageMove.redirect(request, response, "/login/loginok.jsp");
			} else {
				PageMove.redirect(request, response, "/login/loginfail.jsp");
			}
		} else if("logout".equals(act)) {
			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", null);
			session.removeAttribute("userInfo");
//			session.invalidate();
			PageMove.redirect(request, response, "/index.jsp");
		} else if("mvmaillist".equals(act)) {
			List<String> mail = new ArrayList<String>();
			mail.add("동주1가 보낸 메일.");
			mail.add("동주2가 보낸 메일.");
			mail.add("동주3가 보낸 메일.");
			mail.add("동주4가 보낸 메일.");
			mail.add("동주5가 보낸 메일.");
			mail.add("동주6가 보낸 메일.");
			
			request.setAttribute("maillist", mail);
			PageMove.forward(request, response, "/mail/list.jsp");
		} else {
			PageMove.redirect(request, response, "/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}


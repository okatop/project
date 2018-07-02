package com.indiya.action.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.indiya.action.Action;
import com.indiya.funding.model.FundingDto;
import com.indiya.funding.service.FundingServiceImpl;

public class FundingWriteAction implements Action {

	private static FundingWriteAction fundingWriteAction;

	static {
		fundingWriteAction = new FundingWriteAction();
	}

	private FundingWriteAction() {
	}

	public static FundingWriteAction getFundingWriteAction() {
		return fundingWriteAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/reboard/writefail.jsp?";
		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
//		if(memberDto != null) {
//		TODO Login check
		if(true) {
			FundingDto fundingDto = new FundingDto();
			fundingDto.setMusician_id(request.getParameter("musician_id"));
			fundingDto.setPic(request.getParameter("pic"));
			fundingDto.setCategory(request.getParameter("category"));
			fundingDto.setGoal(Integer.parseInt(request.getParameter("goal")));
			fundingDto.setOpen(request.getParameter("open"));
			fundingDto.setClose(request.getParameter("close"));
			fundingDto.setTitle(request.getParameter("title"));
			fundingDto.setContents(request.getParameter("contents"));
			
			int seq = FundingServiceImpl.getFundingService().writeFunding(fundingDto);
			if(seq != 0) {
				path = "funding/list.jsp?seq=" + seq + "&";
			}
		}else {					
			path = "/funding/index.jsp?";
		}
		return path;
	}

}

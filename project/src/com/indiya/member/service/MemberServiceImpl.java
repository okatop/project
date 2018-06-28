package com.indiya.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.indiya.member.dto.MemberDto;
import com.indiya.member.dto.ZipDto;
import com.indiya.member.dao.MemberDao;
import com.indiya.member.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{

private MemberDao memberDao;
	
@Override
public int idCheck(String id) {
	return memberDao.idCheck(id);
}

@Override
public List<ZipDto> zipSearch(String dong) {
	return memberDao.zipSearch(dong);
}

@Override
public int registerMember(MemberDto memberDto) {
	return memberDao.registerMember(memberDto);
}

@Override
public MemberDto getMember(String id) {
	return memberDao.getMember(id);
}

@Override
public int modifyMember(MemberDto memberDto) {
	return memberDao.modifyMember(memberDto);
}

@Override
public void deleteMember(String id) {
}

@Override
public MemberDto login(String id, String pass) {
	Map<String, String> map = new HashMap<String, String>();
	map.put("userid", id);
	map.put("userpass", pass);
	return memberDao.login(map);
	}
}

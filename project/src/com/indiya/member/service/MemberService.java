package com.indiya.member.service;

import java.util.List;

import com.indiya.member.dto.MemberDto;
import com.indiya.member.dto.ZipDto;

public interface MemberService {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int registerMember(MemberDto memberDto);
	MemberDto getMember(String id);
	int modifyMember(MemberDto memberDto);
	void deleteMember(String id);
	
	MemberDto login(String id, String pass);
}

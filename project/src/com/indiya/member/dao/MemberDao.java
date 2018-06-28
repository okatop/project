package com.indiya.member.dao;

import java.util.List;
import java.util.Map;

import com.indiya.member.dto.MemberDto;
import com.indiya.member.dto.ZipDto;

public interface MemberDao {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int registerMember(MemberDto memberDto);
	MemberDto getMember(String id);
	int modifyMember(MemberDto memberDto);
	void deleteMember(String id);
	
	MemberDto login(Map<String, String> map);
}

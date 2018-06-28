package com.indiya.musician.dao;

import com.indiya.member.dto.MemberDto;


public interface MusicainDao {

	int registerMember(MemberDto memberDto);
	int nameCheck(String band_name);
	MemberDto getMember(String id);
}

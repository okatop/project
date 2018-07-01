package com.indiya.funding.dao;

import java.util.List;
import java.util.Map;

import com.indiya.funding.model.FundingDto;

public interface FundingDao {
	List<FundingDto> getFundingList(Map<String, String> map);		//리스트
	FundingDto viewFundingDetail(int no);							//상세
	
	void changeStatusFunding(Map<String, String> map);				//승인, 만료, map(status, no)
	
	void writeFunding(FundingDto fundingDto);						//신청
	void modifyFunding(FundingDto fundingDto);						//수정
	void deleteFunding(int no);										//삭제
	
	void backingFunding(Map<String, String> map);					//후원 , map(no, id, amount)
}

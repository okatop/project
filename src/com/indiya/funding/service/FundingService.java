package com.indiya.funding.service;

import java.util.List;
import java.util.Map;

import com.indiya.funding.model.FundingDto;
import com.indiya.funding.model.FundingRewardDto;

public interface FundingService {
	List<FundingDto> getFundingList(Map<String, String> map);		//리스트
	List<FundingRewardDto> getFundingRewardList(int no);			//리워드리스트
	
	FundingDto viewFundingDetail(int no);							//상세
	
	void changeStatusFunding(int no, String status);				//승인, 만료, map(status, no)
	
	void writeFunding(FundingDto fundingDto);						//신청
	void modifyFunding(FundingDto fundingDto);						//수정
	void deleteFunding(int no);										//삭제
	
	void backingFunding(int no, String member_id, int amount);		//후원 , map(no, id, amount)
}

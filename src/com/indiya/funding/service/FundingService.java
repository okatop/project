package com.indiya.funding.service;

import java.util.List;
import java.util.Map;

import com.indiya.funding.model.FundingDto;

public interface FundingService {
	List<FundingDto> getFundingList(Map<String, String> map);		//����Ʈ
	FundingDto viewFundingDetail(int no);							//��
	
	void changeStatusFunding(int no, String status);				//����, ����, map(status, no)
	
	void writeFunding(FundingDto fundingDto);						//��û
	void modifyFunding(FundingDto fundingDto);						//����
	void deleteFunding(int no);										//����
	
	void backingFunding(int no, String member_id, int amount);					//�Ŀ� , map(no, id, amount)
}

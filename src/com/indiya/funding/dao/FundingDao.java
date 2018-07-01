package com.indiya.funding.dao;

import java.util.List;
import java.util.Map;

import com.indiya.funding.model.FundingDto;

public interface FundingDao {
	List<FundingDto> getFundingList(Map<String, String> map);		//����Ʈ
	FundingDto viewFundingDetail(int no);							//��
	
	void changeStatusFunding(Map<String, String> map);				//����, ����, map(status, no)
	
	void writeFunding(FundingDto fundingDto);						//��û
	void modifyFunding(FundingDto fundingDto);						//����
	void deleteFunding(int no);										//����
	
	void backingFunding(Map<String, String> map);					//�Ŀ� , map(no, id, amount)
}

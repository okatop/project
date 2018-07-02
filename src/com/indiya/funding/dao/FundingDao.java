package com.indiya.funding.dao;

import java.util.List;
import java.util.Map;

import com.indiya.funding.model.FundingDto;
import com.indiya.funding.model.FundingRewardDto;

public interface FundingDao {
	int getNextSeq();												//���� �� ��ȣ
	List<FundingDto> getFundingList(Map<String, String> map);		//����Ʈ
	List<FundingRewardDto> getFundingRewardList(int no);			//�����帮��Ʈ
	FundingDto viewFundingDetail(int no);							//��
	
	void changeStatusFunding(Map<String, String> map);				//����, ����, map(status, no)
	
	int writeFunding(FundingDto fundingDto);						//��û
	void modifyFunding(FundingDto fundingDto);						//����
	void deleteFunding(int no);										//����
	
	void backingFunding(Map<String, String> map);					//�Ŀ� , map(no, id, amount)
}

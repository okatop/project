package com.indiya.funding.service;

import java.util.List;

import com.indiya.funding.model.FundingDto;
import com.indiya.funding.model.FundingRewardDto;

public interface FundingService {
	//TODO map�� �˻� ����(�̸� ��), ����(����, ���, ����), reward����Ʈ
	List<FundingDto> getFundingList(int pg, String key, String word);		//����Ʈ
	List<FundingRewardDto> getFundingRewardList(int no);			//�����帮��Ʈ
	
	FundingDto viewFundingDetail(int no);							//��
	
	void changeStatusFunding(int no, String status);				//����, ����, map(status, no)
	
	int writeFunding(FundingDto fundingDto);						//��û
	int writeFundingReward(List<FundingRewardDto> list);			//������
	void modifyFunding(FundingDto fundingDto);						//����
	void deleteFunding(int no);										//����
	
	void backingFunding(int no, String member_id, int amount);		//�Ŀ� , map(no, id, amount)
}

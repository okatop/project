package com.indiya.funding.service;

import java.util.List;
import java.util.Map;

import com.indiya.funding.dao.FundingDaoImpl;
import com.indiya.funding.model.FundingDto;
import com.indiya.funding.model.FundingRewardDto;

public class FundingServiceImpl implements FundingService {

	private static FundingService fundingService;

	static {
		fundingService = new FundingServiceImpl();
	}

	private FundingServiceImpl() {}

	public static FundingService getFundingService() {
		return fundingService;
	}

	@Override
	public List<FundingDto> getFundingList(Map<String, String> map) {
		return null;
	}

	@Override
	public List<FundingRewardDto> getFundingRewardList(int no) {
		return null;
	}

	@Override
	public FundingDto viewFundingDetail(int no) {
		return null;
	}

	@Override
	public void changeStatusFunding(int no, String status) {

	}

	@Override
	public int writeFunding(FundingDto fundingDto) {
		int seq = FundingDaoImpl.getFundingDao().getNextSeq();
		fundingDto.setNo(seq);
		return FundingDaoImpl.getFundingDao().writeFunding(fundingDto) == 0 ? 0 : seq;
	}

	
	@Override
	public int writeFundingReward(List<FundingRewardDto> list) {
		int size = list.size();
		for(int i=0; i<size; i++) {
			FundingDaoImpl.getFundingDao().writeFundingReward(list.get(i));
		}
		return 0;
	}

	@Override
	public void modifyFunding(FundingDto fundingDto) {

	}

	@Override
	public void deleteFunding(int no) {

	}

	@Override
	public void backingFunding(int no, String member_id, int amount) {

	}

}

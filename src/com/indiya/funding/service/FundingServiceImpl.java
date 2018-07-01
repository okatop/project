package com.indiya.funding.service;

import java.util.List;
import java.util.Map;

import com.indiya.funding.model.FundingDto;

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
	public FundingDto viewFundingDetail(int no) {
		return null;
	}

	@Override
	public void changeStatusFunding(int no, String status) {

	}

	@Override
	public void writeFunding(FundingDto fundingDto) {

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

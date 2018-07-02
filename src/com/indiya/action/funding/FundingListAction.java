package com.indiya.action.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indiya.action.Action;

public class FundingListAction implements Action {

	private static FundingListAction fundingListAction;

	static {
		fundingListAction = new FundingListAction();
	}

	private FundingListAction() {
	}

	public static FundingListAction getFundingListAction() {
		return fundingListAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

}

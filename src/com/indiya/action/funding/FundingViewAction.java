package com.indiya.action.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indiya.action.Action;

public class FundingViewAction implements Action {

	private static FundingViewAction fundingViewAction;

	static {
		fundingViewAction = new FundingViewAction();
	}

	private FundingViewAction() {
	}

	public static FundingViewAction getFundingViewAction() {
		return fundingViewAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

}

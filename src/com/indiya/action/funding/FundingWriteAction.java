package com.indiya.action.funding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indiya.action.Action;

public class FundingWriteAction implements Action {

	private static FundingWriteAction fundingWriteAction;

	static {
		fundingWriteAction = new FundingWriteAction();
	}

	private FundingWriteAction() {
	}

	public static FundingWriteAction getFundingWriteAction() {
		return fundingWriteAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

}

package com.indiya.util;

public class ParameterCheck {

	public static String nullToBlank(String str) {
		return str == null ? "" : str;
	}

	public static int naNToZero(String numStr) {
		int num = 0;
		if (isNumber(numStr)) {
			num = Integer.parseInt(numStr);
		}
		return num;
	}

	public static int naNToOne(String numStr) {
		int num = 1;
		if (isNumber(numStr)) {
			num = Integer.parseInt(numStr);
		}
		return num;
	}

	private static boolean isNumber(String numStr) {
		boolean flag = true;
		if (numStr != null && !numStr.isEmpty()) {
			char[] charArr = numStr.toCharArray();
			for (char c : charArr) {
				if (c < 48 || c > 57) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}

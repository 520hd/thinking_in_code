package com.hd520.thinking_in_code.dynamic_pro;

import com.hd520.thinking_in_code.util.ArrayUtils;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-09 15:13:45
 */
public class Test {

	public String longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return null;
		}
		char[] charArr = s.toCharArray();
		int[][] dp = new int[charArr.length][charArr.length];
		int maxi = -1;
		int maxj = -1;
		int max = 0;

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if (i > j) {
					dp[i][j] = 0;
				}
				if (i == j) {
					dp[i][j] = 1;
					if (dp[i][j] > max) {
						max = dp[i][j];
						maxi = i;
						maxj = j;
					}
				}
			}
		}


		for (int i = charArr.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < charArr.length; j++) {
				if (charArr[i] == charArr[j] && dp[i + 1][j - 1] == j - i - 1) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
					if (dp[i][j] > max) {
						max = dp[i][j];
						maxi = i;
						maxj = j;
					}
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					if (dp[i][j] > max) {
						max = dp[i][j];
						maxi = i;
						maxj = j;
					}
				}
			}
		}

//		for (int j = 1; j < charArr.length; j++) {
//			for (int i = 0; i < j; i++) {
//				if (charArr[i] == charArr[j]) {
//					dp[i][j] = dp[i + 1][j - 1] + 2;
//					if (dp[i][j] > max) {
//						max = dp[i][j];
//						maxi = i;
//						maxj = j;
//					}
//				} else {
//					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//					if (dp[i][j] > max) {
//						max = dp[i][j];
//						maxi = i;
//						maxj = j;
//					}
//				}
//			}
//		}
		ArrayUtils.printTwoDimensionArrayInt(dp);
		return s.substring(maxi, maxj + 1);

	}

	public static void main(String[] args) {
		Test test = new Test();
		String str = test.longestPalindrome("aacabdkacaa");
		System.out.println(str);
	}
}

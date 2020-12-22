package com.hd520.thinking_in_code.dynamic_pro;

/**
 * @Description 插入字符次数最少,使得目标字符串变为回文串
 * @Author xierishi
 * @Date 2020-12-22 23:28:24
 */
public class MinInsertion {

	public int minInsertion(String word) {

		int len = word.length();
		int[][] dp = new int[len][len];

		// base case
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i >= j) {
					dp[i][j] = 0;
				}
			}
		}

		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (word.charAt(i) == word.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp[0][len - 1];
	}
}

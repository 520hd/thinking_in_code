package com.hd520.thinking_in_code.dynamic_pro;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-20 19:53:20
 */
public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String str1, String str2) {

		int str1Len = str1.length();
		int str2Len = str2.length();

		int[][] dp = new int[str1Len + 1][str2Len + 1];

		// base case
		// 当str1为空或者str2为空的时候, 此时的最长公共子序列的长度均为0
		for (int i = 0; i <= str1Len; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= str2Len; i++) {
			dp[0][i] = 0;
		}

		for (int i = 0; i < str1Len; i++) {
			for (int j = 0; j < str2Len; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					// 当当前的字符相等的时候, 则最大值就是
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}

			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		return dp[str1Len][str2Len];

	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int lcsLength = lcs.longestCommonSubsequence("ac", "babc");
		System.out.println(lcsLength);
	}
}

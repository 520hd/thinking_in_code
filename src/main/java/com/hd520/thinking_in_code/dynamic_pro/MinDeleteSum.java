package com.hd520.thinking_in_code.dynamic_pro;

/**
 * @Description 删除字符使得两个字符串相等,同时删除的ASCII码值最小
 * @Author xierishi
 * @Date 2020-12-22 16:27:04
 */
public class MinDeleteSum {

	public int minDeleteSum(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();
		Integer[][] dp = new Integer[len1 + 1][len2 + 1];

		// base case
		dp[0][0] = 0;
		for (int i = 1; i <= len1; i++){
			dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
		}
		for (int i = 1; i <= len2; i++){
			dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
		}

		for (int i = 0; i < len1 ; i++) {
			for (int j = 0; j < len2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				}else {
					dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + s2.charAt(j), dp[i][j + 1] + s1.charAt(i));
				}
			}
		}
		return dp[len1][len2];
	}

	public static void main(String[] args) {

		MinDeleteSum minDeleteSum = new MinDeleteSum();
		int minDelete = minDeleteSum.minDeleteSum("sea", "eat");
		System.out.println(minDelete);

	}
}

package com.hd520.thinking_in_code.dynamic_pro;

/**
 * @Description 删除字符使得两个字符串相等, 最少需要多少步
 * @Author xierishi
 * @Date 2020-12-22 16:27:04
 */
public class MinDeleteDistance {

	public int minDistance(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();
		Integer[][] dp = new Integer[len1 + 1][len2 + 1];

		// base case
		for (int i = 0; i <= len1; i++){
			dp[i][0] = i;
		}
		for (int i = 0; i <= len2; i++){
			dp[0][i] = i;
		}

		for (int i = 0; i < len1 ; i++) {
			for (int j = 0; j < len2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				}else {
					dp[i + 1][j + 1] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
				}
			}
		}
		return dp[len1][len2];
	}

	public static void main(String[] args) {

		MinDeleteDistance minDeleteDistance = new MinDeleteDistance();
		int minDistance = minDeleteDistance.minDistance("sea", "eat");
		System.out.println(minDistance);

	}
}

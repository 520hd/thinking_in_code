package com.hd520.thinking_in_code.dynamic_pro;

import java.util.Arrays;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-20 15:33:34
 */
public class LongestIncreasingSubsequence {

	/**
	 * 求解最长递增子序列
	 * @param nums 原始给定的数组
	 * @return 返回最长递增子序列的的长度
	 */
	public int lengthOfLIS(int[] nums) {

		// 明确dp[i]数组的含义: 以index为i结尾的元素的最长递增子序列的大小
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int maxLengthOfLIS = 1;
		for (int i = 0; i < dp.length; i++) {
			maxLengthOfLIS = Math.max(maxLengthOfLIS, dp[i]);
		}
		return maxLengthOfLIS;

	}

	public static void main(String[] args) {

		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int length = lis.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(length);
	}
}

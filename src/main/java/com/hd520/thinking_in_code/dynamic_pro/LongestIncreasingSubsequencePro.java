package com.hd520.thinking_in_code.dynamic_pro;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-20 16:35:55
 */
public class LongestIncreasingSubsequencePro {

	/**
	 * 信封嵌套问题
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {

		// 假设envelopes元素的第一个参数是信封的长, 第二个参数是信封的宽
		// 按照长进行升序排序,然后长相同的再按照宽进行降序排序

		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
			}
		});

		int[] dp = new int[envelopes.length];
		Arrays.fill(dp, 1);
		// 然后将问题转化为宽序列的最大递增子序列
		for (int i = 0; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][1] < envelopes[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int maxEnvelops = 1;
		for (int i = 0; i < dp.length; i++) {
			maxEnvelops = Math.max(maxEnvelops, dp[i]);
		}
		return maxEnvelops;

	}
}

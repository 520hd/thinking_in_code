package com.hd520.thinking_in_code.dynamic_pro;

import com.hd520.thinking_in_code.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-10 22:41:42
 */
public class Test1 {

	public int calculateMinimumHP(int[][] dungeon) {

		int n = dungeon.length, m = dungeon[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; ++i) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		ArrayUtils.printTwoDimensionArrayInt(dp);
		dp[n][m - 1] = dp[n - 1][m] = 1;
		// 动态规划 其实就是可以转化为数学归纳
		// 主要就是要寻找base case 而本题的base case是在公主的位置,当到达公主位置必选要能够活下来才可以
		// 此时可以算出,公主位置的最低初始数据.
		for (int i = n - 1; i >= 0; --i) {
			for (int j = m - 1; j >= 0; --j) {
				int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = Math.max(minn - dungeon[i][j], 1);
			}
		}
		ArrayUtils.printTwoDimensionArrayInt(dp);
		return dp[0][0];
	}

	public static void main(String[] args) {

		int[] ints1 = {-2, -3, 3};
		int[] ints2 = {-5,-10,1};
		int[] ints3 = {10,30,-5};
		int[][] ints = {ints1, ints2, ints3};
		Test1 test1 = new Test1();
		int i = test1.calculateMinimumHP(ints);
		System.out.println(i);
	}
}

package com.hd520.thinking_in_code.dynamic_pro;

/**
 * 两个字符串的最短编辑距离
 * @Description
 * @Author xierishi
 * @Date 2020-12-18 23:57:26
 */
public class MiniDistance {

	/**
	 * 将s1转化为s2
	 * 运用暴力递归的方式
	 * @param s1 待转化字符串
	 * @param s2 目标字符串
	 * @return
	 */
	public int miniDistance(String s1, String s2) {

		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();

		int i = chars1.length - 1;
		int j = chars2.length - 1;

		return backtrack(i, j, chars1, chars2);
	}

	private int backtrack(int i, int j, char[] chars1, char[] chars2) {

		// base case
		// 当i < 0的时候,即s1需要插入s2剩余的字母
		// 当j < 0的时候,即s1需要将剩余的字母删除
		if (i < 0) {
			return j + 1;
		}
		if (j < 0) {
			return i + 1;
		}

		if (chars1[i] == chars2[j]) {
			return backtrack(i - 1, j - 1, chars1, chars2);
		} else {
			return min(backtrack(i - 1, j - 1, chars1, chars2) + 1,
					backtrack(i, j - 1, chars1, chars2) + 1,
					backtrack(i - 1 ,j, chars1, chars2) + 1);
		}
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	/**
	 * 运用动态规划进行求解
	 * @param s1 待转化字符串
	 * @param s2 目标字符串
	 * @return
	 */
	public int miniDistanceWithDynamic(String s1, String s2) {

		int i = s1.length();
		int j = s2.length();
		int dp[][] = new int[i + 1][j + 1];
		// base case
		for (int k = 1; k <= i; k++) {
			dp[k][0] = k;
		}
		for (int k = 1; k <= j; k++) {
			dp[0][k] = k;
		}

		for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				if (s1.charAt(k - 1) == s2.charAt(l - 1)) {
					dp[k][l] = dp[k - 1][l - 1];
				} else {
					dp[k][l] = min(dp[k][l - 1] + 1, dp[k - 1][l] + 1, dp[k - 1][l - 1] + 1);
				}
			}
		}
		return dp[i][j];
	}




	public static void main(String[] args) {
		String str1 = "horse";
		String str2 = "ros";
		MiniDistance miniDistance = new MiniDistance();
		int distance = miniDistance.miniDistance(str1, str2);
		System.out.println(distance);

		int miniDistanceWithDynamic = miniDistance.miniDistanceWithDynamic(str1, str2);
		System.out.println(miniDistanceWithDynamic);
	}

}

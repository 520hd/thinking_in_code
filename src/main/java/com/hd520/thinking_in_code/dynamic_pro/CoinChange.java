package com.hd520.thinking_in_code.dynamic_pro;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-18 16:49:17
 */
public class CoinChange {


	/**
	 * 暴力递归解决问题
	 * 这个解法的时间复杂度比较大
	 * 当入参coins=[1, 2, 5] amount=100时就会超时
	 * @param coins 可选零钱的列表
	 * @param amount 目标金额
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {

		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		int res = Integer.MAX_VALUE;
		for (int coin : coins) {
			int subProblem = coinChange(coins, amount - coin);
			if (subProblem == -1) {
				continue;
			}
			res = Math.min(res, 1 + subProblem);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	/**
	 * 暴力递归解决 + 备忘录
	 * @param coins 可选零钱的列表
	 * @param amount 目标金额
	 * @return
	 */
	private Map<Integer, Integer> mem = new HashMap<>();
	public int coinChangeWithMem(int[] coins, int amount){

		if (mem.get(amount) != null) {
			return mem.get(amount);
		}
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		int res = Integer.MAX_VALUE;
		for (int coin : coins) {
			int subProblem = coinChangeWithMem(coins, amount - coin);
			if (subProblem == -1) {
				continue;
			}
			res = Math.min(res, 1 + subProblem);
		}
		mem.put(amount, res == Integer.MAX_VALUE ? -1 : res);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	/**
	 * 利用动态规划进行解答
	 * base case: amount = 0 return 0
	 * 状态: 面额是给定的且零钱的数量数无限的,一次每次变更的状态就是amount,不断向base case靠近
	 * 选择: 每次的选择都是从零钱中选择,且每次的选择都是一致的
	 * 而dp状态方程如下:
	 * dp(0) = 0;
	 * dp(n) = min(dp(n - coin) + 1)
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChangeWithDynamic(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		// 对状态函数进行初始化
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		// base case
		dp[0] = 0;

		// 进行状态的流转
		for (int i = 0; i <= amount; i++) {
			// 每次进行选择,选择不同面值的零钱进行计算
			for(int coin : coins) {
				if (i - coin < 0) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		return (dp[amount] == amount + 1) ? -1 : dp[amount];
	}

	public static void main(String[] args) {

		CoinChange coinChange = new CoinChange();
		int[] coins = new int[]{186,419,83,408};
		int coinChangeCount = coinChange.coinChangeWithMem(coins, 6249);
		System.out.println(coinChangeCount);

		int coinChangeWithDynamic = coinChange.coinChangeWithDynamic(new int[]{2}, 3);
		System.out.println(coinChangeWithDynamic);

	}
}

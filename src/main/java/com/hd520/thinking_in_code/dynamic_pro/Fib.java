package com.hd520.thinking_in_code.dynamic_pro;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-18 16:21:28
 */
public class Fib {

	/**
	 * 运用暴力递归的方法进行解答
	 * @param n
	 * @return
	 */
	public int fibRecursion(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}


	Map<Integer, Integer> mem = new HashMap<>();

	/**
	 * 添加备忘录的递归方法
	 * @param n
	 * @return
	 */
	public int fibRecursionWithMem(int n) {

		if (n == 1 || n == 2) {
			return 1;
		}
		if (mem.getOrDefault(n, -1) != -1) {
			return mem.get(n);
		}
		int ret = fibRecursionWithMem(n - 1) + fibRecursionWithMem(n - 2);
		mem.putIfAbsent(n, ret);
		return ret;
	}

	/**
	 * 运用自底向上进行求值
	 * @param n
	 * @return
	 */
	public int fibWithDynamic(int n) {

		int[] ret = new int[n + 2];
		ret[1] = 1;
		ret[0] = 1;

		for (int i = 3; i <= n; i++) {
			// 状态的传递
			ret[i] = ret[i - 1] + ret[i - 2];
		}
		return ret[n] % 1000000007;
	}

	/**
	 * 优化空间复杂度
	 * @param n
	 * @return
	 */
	public int fibWithDynamicPro(int n) {

		int prePre = 1;
		int pre = 1;

		int now = 0;
		for (int i = 3; i <= n; i++) {
			now = prePre + pre;
			prePre = pre;
			pre = now;
		}
		return now;
	}

	public static void main(String[] args) {
		Fib fib = new Fib();
		int n = 45;
		int fibRecursion = fib.fibRecursion(45);
		int fibRecursionWithMem = fib.fibRecursionWithMem(45);
		int fibWithDynamic = fib.fibWithDynamic(48);
		int fibWithDynamicPro = fib.fibWithDynamicPro(48);
		System.out.println("fibRecursion = " + fibRecursion + " \nfibRecursionWithMem = " + fibRecursionWithMem + " \nfibWithDynamic = " + fibWithDynamic + " \nfibWithDynamicPro = " + fibWithDynamicPro);
	}

	
}

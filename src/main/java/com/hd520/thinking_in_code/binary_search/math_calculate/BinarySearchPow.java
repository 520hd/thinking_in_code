package com.hd520.thinking_in_code.binary_search.math_calculate;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-09 16:40:54
 */
public class BinarySearchPow {

	public double myPow(double x, int n) {

		if (n >= 0) {
			return handle(x, n);
		} else {
			return 1 / handle(x, -n);
		}

	}


	/**
	 * 快速幂
	 * @param x
	 * @param n
	 * @return
	 */
	private double myPowNew(double x, int n) {

		double ret = 1.0;
		for (int i = n; i != 0; i /= 2) {

			if (i % 2 != 0) {
				ret *= x;
			}
			x *= x;
		}
		return n > 0 ? ret : 1 / ret;
	}

	private double handle(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		int i = 2;
		double ret = x * x;
		while (2 * i < n) {

			i *= 2;
			ret = ret * ret;
		}
		return ret * myPow(x, n - i);
	}

	public static void main(String[] args) {
		BinarySearchPow binarySearchPow = new BinarySearchPow();
//		double myPow = binarySearchPow.myPow(0.00001, 2147483647);
		double myPowNew = binarySearchPow.myPowNew(2, 2);
//		System.out.println(myPow);
		System.out.println(myPowNew);
		System.out.println(Math.pow(2, 2));
	}
}

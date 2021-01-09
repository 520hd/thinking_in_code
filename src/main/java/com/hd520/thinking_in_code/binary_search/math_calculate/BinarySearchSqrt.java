package com.hd520.thinking_in_code.binary_search.math_calculate;

/**
 * @Description 求平方根
 * @Author xierishi
 * @Date 2021-01-09 19:41:07
 */
public class BinarySearchSqrt {

	public int sqrt(int x) {

		if (x == 1) {
			return 1;
		}
		int low = 0;
		int high = x;
		// 因为我们要找的目标就是需要low和high相差为1, 取小值即可
		// 因此可以进入循环的条件是high - low > 1  当high - low <= 1事就是求值成功
		while (high - low > 1) {
			int mid = low + (high - low) / 2;
			// 为了防止溢出 不直接进行操作mid * mid
			if (x / mid >= mid) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return low;
	}
}

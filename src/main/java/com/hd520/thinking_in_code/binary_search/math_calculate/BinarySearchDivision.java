package com.hd520.thinking_in_code.binary_search.math_calculate;

/**
 * @Description 运用二分法进行操作除法
 * @Author xierishi
 * @Date 2021-01-08 16:23:49
 */
public class BinarySearchDivision {

	public int divide(int dividend, int divisor) {

		if (divisor == 0) {
			throw new IllegalArgumentException("被除数不能为0");
		}
		if (dividend == 0) {
			return 0;
		}
		if(divisor == -1){
			if(dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
			return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
		}
		int ret;
		boolean isSameSymbol = (dividend ^ divisor) >>> 31 == 0;
		if (isSameSymbol) {
			dividend = dividend > 0 ? dividend : -dividend;
			divisor = divisor > 0 ? divisor : -divisor;
			ret = divideHandle(dividend, divisor);
		} else {
			dividend = dividend > 0 ? dividend : -dividend;
			divisor = divisor > 0 ? divisor : -divisor;
			ret = -divideHandle(dividend, divisor);
		}
		return ret;
	}

	private int divideHandle(int dividend, int divisor) {

		if (dividend < divisor) {
			return 0;
		}
		int ret = 1;
		int reduce = divisor;
		dividend -= reduce;
		while (dividend - reduce > 0) {
			dividend -= reduce;
			reduce += reduce;
			ret += ret;
		}
		return ret + divideHandle(dividend, divisor);
	}

	/**
	 * 为了避免溢出,可以将所有的数转为负数进行运算
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divideNew(int dividend, int divisor) {

		if (divisor == 0) {
			throw new IllegalArgumentException("被除数不能为0");
		}
		if (dividend == 0) {
			return 0;
		}
		if(divisor == -1){
			if(dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
			return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
		}

		int ret = 0;
//        boolean isSameSymbol = (dividend ^ divisor) >>> 31 == 0;
//        if (isSameSymbol) {
//            dividend = dividend < 0 ? dividend : -dividend;
//            divisor = divisor < 0 ? divisor : -divisor;
//            ret = divideNewHandle(dividend, divisor);
//        } else {
//            dividend = dividend < 0 ? dividend : -dividend;
//            divisor = divisor < 0 ? divisor : -divisor;
//            ret = -divideNewHandle(dividend, divisor);
//        }
		if (dividend < 0 && divisor < 0) {
			ret = divideNewHandle(dividend, divisor);
		} else if (dividend > 0 && divisor > 0) {
			ret = divideNewHandle(-dividend, -divisor);
		} else if (dividend > 0 && divisor < 0) {
			ret = -divideNewHandle(-dividend, divisor);
		} else if (dividend < 0 && divisor > 0) {
			ret = -divideNewHandle(dividend, -divisor);
		}
		return ret;
	}

	private int divideNewHandle(int divide, int divisor) {

		if (divide > divisor) {
			return 0;
		}
		int ret = 1;
		int reduce = divisor;
		divide -= reduce;
		if (divide == 0) {
			return ret;
		}
		while (divide - reduce < 0) {
			divide -= reduce;
			reduce += reduce;
			ret += ret;
		}
		return ret + divideNewHandle(divide, divisor);
	}

	public static void main(String[] args) {

		BinarySearchDivision binarySearchDivision = new BinarySearchDivision();
		int divide = binarySearchDivision.divide(-2147483648, -2147483648);
		System.out.println(divide);
		int divideNew = binarySearchDivision.divideNew(-2147483648, -2147483648);
		System.out.println(divideNew);

	}

	private static boolean judge(int a, int b) {

		System.out.println(a ^ b);
		return (a ^ b) > 0;
	}
}

package com.hd520.thinking_in_code.util;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-16 22:56:58
 */
public class ArrayUtils {

	public static <T> void  printTwoDimensionArray(T[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public static void  printTwoDimensionArrayInt(int[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();

	}
}

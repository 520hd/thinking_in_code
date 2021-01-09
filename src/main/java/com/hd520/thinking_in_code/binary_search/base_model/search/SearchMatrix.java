package com.hd520.thinking_in_code.binary_search.base_model.search;

/**
 * @Description 从矩阵中二分查找目标值
 * 对索引进行二分
 * @Author xierishi
 * @Date 2021-01-09 21:47:07
 */
public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int left = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int right = n * m - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			// 这一步最重要, 通过摊平的索引获取到指定的值
			int indexVal = matrix[mid / n][mid % n];
			if (indexVal == target) {
				return true;
			} else if (indexVal > target) {
				right = mid - 1;
			} else if (indexVal < target) {
				left = mid + 1;
			}
		}
		return false;
	}
}

package com.hd520.thinking_in_code.binary_search.rotate_array;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-09 13:18:02
 */
public class FindRotateArrayMin {

	/**
	 * 寻找最小值
	 * 暂时不考虑重复值
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			}
		}
		return left;
	}

	/**
	 * 寻找最小值,考虑重复值
	 * @param nums
	 * @return
	 */
	public int findMinWithSameValue(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			} else if (nums[mid] == nums[right]) {
				// 考虑到相同数的时候，需要右端索引减1
				right--;
			}
		}
		return left;
	}
}

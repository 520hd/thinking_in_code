package com.hd520.thinking_in_code.binary_search.base_model;

/**
 * @Description 二分查找某个数,假设给定的数组已排序且数据不重复
 * @Author xierishi
 * @Date 2021-01-07 22:38:30
 */
public class BinarySearchTarget {

	public int binarySearch(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left);
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = new int[]{1,2,4,6,7,8,9,10};
		BinarySearchTarget binarySearchTarget = new BinarySearchTarget();
		int index = binarySearchTarget.binarySearch(nums, 11);
		System.out.println(index);
	}
}

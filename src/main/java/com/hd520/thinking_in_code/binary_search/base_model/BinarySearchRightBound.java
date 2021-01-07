package com.hd520.thinking_in_code.binary_search.base_model;


/**
 * @Description 查找右边界
 * @Author xierishi
 * @Date 2021-01-07 22:59:17
 */
public class BinarySearchRightBound {

	public int searchRightBound(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length;

		while (left < right) {

			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] == target) {
				// 当找到和目标值一样的元素的时候, 收缩左边界, 往右边界靠近
				left = mid + 1;
			}
		}
		if (nums[right - 1] != target) {
			return -1;
		}
		return right - 1;
	}

	public int searchRightBoundCommon(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] == target) {
				left = mid + 1;
			}
		}
		if (right == 0 || nums[right] != target) {
			return -1;
		}
		return right;

	}

	public static void main(String[] args) {
		BinarySearchRightBound binarySearchRightBound = new BinarySearchRightBound();
		int[] nums = new int[]{1,2,4,6,6,6,6,6,7,8,9,10};
		int rightBound = binarySearchRightBound.searchRightBound(nums, 6);
		int rightBoundCommon = binarySearchRightBound.searchRightBoundCommon(nums, 6);
		System.out.println(rightBound);
		System.out.println(rightBoundCommon);

	}

}

package com.hd520.thinking_in_code.binary_search.base_model;


/**
 * @Description 查找左边界
 * @Author xierishi
 * @Date 2021-01-07 22:44:56
 */
public class BinarySearchLeftBound {

	public int searchLeftBound(int[] nums, int target) {

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
				// 当找到和目标值相等的元素,需要缩小右边界,往左挪
				right = mid;
			}
		}
		return nums[left] != target ? 0 : left;
	}

	public int searchLeftBoundCommon(int[] nums, int target) {

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
				right = mid - 1;
			}
		}
		if (left >= nums.length || nums[left] != target) {
			return -1;
		}
		return left;
	}

	public static void main(String[] args) {
		BinarySearchLeftBound binarySearchLeftBound = new BinarySearchLeftBound();
		int[] nums = new int[]{1,2,4,6,6,6,6,6,7,8,9,10};
		int index = binarySearchLeftBound.searchLeftBound(nums, 6);
		int indexCommon = binarySearchLeftBound.searchLeftBoundCommon(nums, 10);

		System.out.println(index);
		System.out.println(indexCommon);
	}
}

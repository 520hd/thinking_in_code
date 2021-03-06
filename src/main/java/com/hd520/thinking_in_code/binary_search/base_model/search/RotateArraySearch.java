package com.hd520.thinking_in_code.binary_search.base_model.search;

/**
 * @Description 在旋转数组中寻找目标值
 * leetcode 33
 * @Author xierishi
 * @Date 2021-01-09 21:23:59
 */
public class RotateArraySearch {

	public int rotateArraySearch(int[] nums, int target) {

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
		int offset = left;
		System.out.println(offset);

		left = 0;
		right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			// 将旋转数组拉平得到实际的中点数据
			int realMid = (mid + offset) % nums.length;

			if (nums[realMid] == target) {
				return realMid;
			} else if (nums[realMid] > target) {
				right = mid - 1;
			} else if (nums[realMid] < target) {
				left = mid + 1;
			}
		}
		return -1;

	}

	public int rotateArraySearchNew(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > nums[left]) {
				if (nums[mid] > target && target >= nums[left]) {
					right = mid - 1;
				} else if (nums[mid] < target || nums[left] >= target) {
					left = mid + 1;
				}
			} else if (nums[mid] < nums[left]) {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else if (nums[mid] > target || nums[right] <= target) {
					right = mid - 1;
				}
			}
		}

		return -1;
	}


	public static void main(String[] args) {
		RotateArraySearch rotateArraySearch = new RotateArraySearch();
		int arraySearch = rotateArraySearch.rotateArraySearch(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2);
		System.out.println(arraySearch);


	}


}

package com.hd520.thinking_in_code.binary_search.base_model.search;

/**
 * @Description 在旋转数组中寻找目标值
 * leetcode 33
 * @Author xierishi
 * @Date 2021-01-09 21:23:59
 */
public class RotateArraySearchWithSameVal {

	public int rotateArraySearch(int[] nums, int target) {

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
			// 如果找到相同的元素需要缩小左边界
			if (nums[mid] == nums[left]) {
				left++;
				continue;
			}
			if (nums[mid] > nums[left]) {
				// 左右边界都要判断一下
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
		RotateArraySearchWithSameVal rotateArraySearch = new RotateArraySearchWithSameVal();
		int arraySearch = rotateArraySearch.rotateArraySearch(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2);
		System.out.println(arraySearch);


	}


}

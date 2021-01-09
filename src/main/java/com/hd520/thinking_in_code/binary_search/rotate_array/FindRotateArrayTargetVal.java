package com.hd520.thinking_in_code.binary_search.rotate_array;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-09 13:50:20
 */
public class FindRotateArrayTargetVal {

	/**
	 * 先找出旋转数组的临界点
	 * 然后再根据临界点进行偏移
	 * @param nums
	 * @param target
	 * @return
	 */
	public int findRotateArrayTargetValIndex(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] < nums[right]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] == nums[right]) {
				right--;
			}
		}
		int offset = left;
		left = 0;
		right = nums.length - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			// 这一步是精髓所在,将搜索旋转排序数组问题转化为普通问题。
			int realMid = (mid + offset) % nums.length;
			if (nums[realMid] == target) {
				return realMid;
			} else if (nums[realMid] < target) {
				left = mid + 1;
			} else if (nums[realMid] > target) {
				right = mid - 1;

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindRotateArrayTargetVal findRotateArrayTargetVal = new FindRotateArrayTargetVal();
		int rotateArrayTargetValIndex = findRotateArrayTargetVal.findRotateArrayTargetValIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
		System.out.println(rotateArrayTargetValIndex);
	}
}

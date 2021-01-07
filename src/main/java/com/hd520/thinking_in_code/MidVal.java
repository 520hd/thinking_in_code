package com.hd520.thinking_in_code;

import java.util.Arrays;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-06 16:18:13
 */
public class MidVal {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int len1 = nums1.length;
		int len2 = nums2.length;

		int[] num = handle(nums1, nums2);
		boolean flag = (len1 + len2) % 2 != 0 ? true : false;
		int index = (len1 + len2) / 2;
		if (flag) {
			return num[index];
		} else {
			double i = (double)(num[index] + num[index - 1]) / 2;
			return i;
		}
	}

	private int[] handle(int[] nums1, int[] nums2) {

		int[] num = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i <= nums1.length - 1 || j <= nums2.length - 1) {
			if (i >= nums1.length && j <= nums2.length) {
				num[index++] = nums2[j++];
			} else if (j >= nums2.length && i <= nums1.length) {
				num[index++] = nums1[i++];
			} else if (nums1[i] <= nums2[j]) {
				num[index++] = nums1[i++];
			} else if (nums2[j] < nums1[i]) {
				num[index++] = nums2[j++];
			}
		}
		System.out.println(Arrays.toString(num));
		return num;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3};
		int[] nums2 = new int[] {4, 5};
		MidVal midVal = new MidVal();
		double medianSortedArrays = midVal.findMedianSortedArrays(nums1, nums2);
		System.out.println(medianSortedArrays);


	}
}

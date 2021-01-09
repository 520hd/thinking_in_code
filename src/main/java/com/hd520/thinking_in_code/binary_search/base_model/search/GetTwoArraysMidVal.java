package com.hd520.thinking_in_code.binary_search.base_model.search;

/**
 * @Description 通过两个正序数组获得中位数
 * @Author xierishi
 * @Date 2021-01-08 15:21:30
 */
public class GetTwoArraysMidVal {

	public double getTwoArrayMidVal(int[] nums1, int[] nums2) {

		int len1 = nums1.length;
		int len2 = nums2.length;

		boolean isOddLength = (len1 + len2) % 2 != 0;
		if (isOddLength) {
			return getKthValFromTwoArray(nums1, nums2, (len1 + len2) / 2);
		} else {
			return (getKthValFromTwoArray(nums1, nums2, (len1 + len2) / 2) + getKthValFromTwoArray(nums1, nums2, (len1 + len2) / 2 + 1)) / 2.0;
		}
	}

	/**
	 * 这个主要是对索引进行二分
	 *
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	private int getKthValFromTwoArray(int[] nums1, int[] nums2, int k) {

		int index1 = 0;
		int index2 = 0;
		int length1 = nums1.length;
		int length2 = nums2.length;

		while(true) {
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			int half = k / 2;
			int newIndex1 = Math.min(length1, index1 + half) - 1;
			int newIndex2 = Math.min(length2, index2 + half) - 1;
			int pivot1 = nums1[newIndex1];
			int pivot2 = nums2[newIndex2];

			if (pivot1 <= pivot2) {
				k -= newIndex1 - index1 + 1;
				index1 = newIndex1 + 1;
			} else if (pivot1 > pivot2) {
				k -= newIndex2 - index2 + 1;
				index2 = newIndex2 + 1;
			}
		}
	}

	public static void main(String[] args) {

		int[] nums1 = new int[] {1, 3};
		int[] nums2 = new int[] {4, 5};
		GetTwoArraysMidVal getTwoArraysMidVal = new GetTwoArraysMidVal();
		double twoArrayMidVal = getTwoArraysMidVal.getTwoArrayMidVal(nums1, nums2);
		System.out.println(twoArrayMidVal);
	}
}

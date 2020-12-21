package com.hd520.thinking_in_code.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description 排序算法练习
 * 均按从小到大的顺序进行排序
 * 原始数据为 4,5,6,3,2,1
 * @Author xierishi
 * @Date 2020-08-02 17:12:23
 */
public class MyArraySort {

	/**
	 * 冒泡排序
	 * 冒泡排序只会操作相邻的两个数据。
	 * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
	 * 如果不满足就让它俩互换。
	 * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
	 * @param originalArray
	 * @return
	 */
	public static int[] myBubbleSort(int[] originalArray) {

		int length =  originalArray.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (originalArray[j] > originalArray[i]) {
					swap(i, j, originalArray);
				}
			}
		}
		return originalArray;
	}

	/**
	 * 插入排序
	 * 插入排序也包含两种操作，一种是元素的比较，一种是元素的移动。
	 * 当我们需要将一个数据 a 插入到已排序区间时，需要拿 a 与已排序区间的元素依次比较大小，找到合适的插入位置。
	 * 找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，这样才能腾出位置给元素 a 插入。
	 * @param originalArray
	 * @return
	 */
	public static int[] myInsertionSort(int[] originalArray) {

		int length =  originalArray.length;

		for (int i = 1; i < length; i++) {
			int compareValue = originalArray[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (compareValue < originalArray[j]) {
					originalArray[j + 1] = originalArray[j];
				} else {
					break;
				}
			}
			originalArray[j + 1] = compareValue;
		}
		return originalArray;
	}

	/**
	 * 选择排序(也就是选择出未排序区间中的最值merge到已排序区间后面)
	 * 选择排序也分为两种操作,一种是元素的比较,一种是元素的交换位置.
	 * 也分为已排序区间和未排序区间,从未排序区间中找出最大/最小的数据和未排序区间的首个数字交换位置.
	 * 这样就可以得到有序数组
	 * @param originalArray
	 * @return
	 */
	public static int[] mySelectionSort(int[] originalArray) {

		int length = originalArray.length;
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				// 这里需要和之前待排区间元素进行比较
				if (originalArray[j] < originalArray[minIndex]){
					minIndex = j;
				}
			}
			swap(i, minIndex, originalArray);
		}
		return originalArray;
	}

	/**
	 * 归并排序
	 * 归并排序的递归公式  merge(array, p, r) = merge(array, p, p + (r - p) / 2) + merge(array, p + (r - p) / 2, r)
	 * 递归的终止条件 p >= r
	 * 还需要进行最终的merge
	 * 时间复杂度 O(n) = O(n/2) + O(n/2) + C(n)
	 * @param originalArray
	 * @return
	 */
	public static int[] myMergeSort(int[] originalArray) {
		if (originalArray == null || originalArray.length == 1) {
			return originalArray;
		}
		mergeSortRecursion(originalArray, 0, originalArray.length - 1);
		return originalArray;
	}

	/**
	 * 归并排序递推逻辑
	 * @param array
	 * @param p
	 * @param r
	 */
	private static void mergeSortRecursion(int[] array, int p, int r) {

		// 递推的终止条件
		if (p >= r){
			return;
		}
		int q = p + (r - p) / 2;
		mergeSortRecursion(array, p, q);
		mergeSortRecursion(array, q + 1, r);
		mergeWithSentry(array, p, q, r);
	}

	/**
	 * 需要将两边的数组合并起来
	 * @param array
	 * @param p
	 * @param q
	 * @param r
	 */
	private static void merge(int[] array, int p, int q, int r) {

		int i = p;
		int j = q + 1;
		int[] tempArray = new int[r - p + 1];
		int k = 0;
		while(i <= q && j <= r) {
			if (array[i] < array[j]) {
				tempArray[k++] = array[i++];
			} else {
				tempArray[k++] = array[j++];
			}
		}
		while (i <= q) {
			tempArray[k++] = array[i++];
		}
		while (j <= r) {
			tempArray[k++] = array[j++];
		}
		for (int l = 0; l <= tempArray.length - 1; l++) {
			array[p + l] = tempArray[l];
		}
	}

	/**
	 * merge算法添加哨兵
	 * @param array
	 * @param p
	 * @param q
	 * @param r
	 */
	private static void mergeWithSentry(int[] array, int p, int q, int r) {

		// 为了能够将哨兵往左右数组尾部插入, 特地将左右数组的大小申请加1
		int[] leftArray = new int[q - p + 2];
		int[] rightArray = new int[r - q + 1];
		for (int i = 0; i < q - p + 1; i++) {
			leftArray[i] = array[i + p];
		}
		for (int i = 0; i < r - q; i++) {
			rightArray[i] = array[i + q + 1];
		}
		// 添加哨兵 因为是从小到大排序,因此添加一个Integer.MAX_VALUE
		leftArray[q - p + 1] = Integer.MAX_VALUE;
		rightArray[r - q] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		int k = p;
		// 终止条件是k <= r
		while(k <= r) {
			// 对左右的有序数组进行判断
			if (leftArray[i] < rightArray[j]) {
				array[k++] = leftArray[i++];
			}else {
				array[k++] = rightArray[j++];
			}
		}
	}

	/**
	 * 快速排序
	 * 递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
	 * 终止条件：p >= r
	 * @param originalArray
	 * @return
	 */
	public static int[] myQuickSort(int[] originalArray) {

		if (originalArray == null || originalArray.length == 1) {
			return originalArray;
		}

		quickSort(originalArray, 0, originalArray.length - 1);
		return originalArray;
	}

	private static void quickSort(int[] originalArray, int p, int r) {

		if (p >= r) {
			return;
		}
		int q = partition(originalArray, p, r);
		quickSort(originalArray, p, q - 1);
		quickSort(originalArray, q + 1, r);
	}

	private static int partition(int[] originalArray, int p, int r) {

		int pivot = r;
		int j = p;
		int i = p;
		while (j < r) {
			if (originalArray[j] < originalArray[pivot]) {
				swap(i, j, originalArray);
				i++;
			}
			j++;
		}
		if (j == r) {
			swap(i, pivot, originalArray);
		}
		return i;
	}

	private static void swap(int beforeSwapIndex, int afterSwapIndex, int[] swappingArray) {
		int temp = swappingArray[afterSwapIndex];
		swappingArray[afterSwapIndex] = swappingArray[beforeSwapIndex];
		swappingArray[beforeSwapIndex] = temp;
	}

	/**
	 * 计数排序
	 * 1)先遍历数组,找出最大值和最小值,创建计数桶数组
	 * 2)然后再遍历数组往计数桶数组中添加数据,记录小于或者等于k的计数桶的数据量
	 * 3)创建一个临时数组
	 * @param originalArray
	 */
	private static int[] myCountingSort(int[] originalArray){

		int length = originalArray.length;
		int max = 0;
		for (int i = 0; i < length; i++) {
			if (originalArray[i] > max) {
				max = originalArray[i];
			}
		}
		// 创建一个计数数组,先统计每个桶上有多少个数据
		int[] countingArray = new int[max + 1];
		for (int i = 0; i < length; i++) {
			countingArray[originalArray[i]] = countingArray[originalArray[i]] + 1;
		}
		// 根据桶的下标,依次累加,统计出小于等于该桶下标的
		for (int i = 1; i < max + 1; i++) {
			countingArray[i] = countingArray[i - 1] + countingArray[i];
		}
		int[] retArray = new int[length];
		for (int i = 0; i < length; i++) {
			retArray[countingArray[originalArray[i]] - 1] = originalArray[i];
			// 需要将计数数组对应桶的计数值减1
			countingArray[originalArray[i]]--;
		}
		return retArray;
	}



	/**
	 * 虽然插入排序和冒泡排序的最好时间复杂度均为N,最差时间复杂度均为N*N,
	 * 但是每次数据搬移的时候冒泡排序需要做3步操作,而插入排序只需要1步操作即可
	 * 因此在工程应用中推荐使用插入排序法
	 * @param args
	 */
	public static void main(String[] args) {
		int[] afterBubbleSortArray = myBubbleSort(new int[]{4, 5, 6, 1, 3, 2});
		int[] afterInsertionSortArray = myInsertionSort(new int[]{4, 5, 6, 1, 3, 2});
		int[] afterSelectionSortArray = mySelectionSort(new int[]{4, 5, 6, 1, 3, 2});
		int[] afterMergeSortArray = myMergeSort(new int[]{4, 5, 6, 1, 3, 2});
		int[] afterQuickSortArray = myQuickSort(new int[]{4, 5, 6, 1, 3, 2});
		int[] afterMyCountingSortArray = myCountingSort(new int[]{4, 4, 6, 5, 3, 5, 6, 1, 3, 2});

		System.out.println(Arrays.toString(afterBubbleSortArray));
		System.out.println(Arrays.toString(afterInsertionSortArray));
		System.out.println(Arrays.toString(afterSelectionSortArray));
		System.out.println(Arrays.toString(afterMergeSortArray));
		System.out.println(Arrays.toString(afterQuickSortArray));
		System.out.println(Arrays.toString(afterMyCountingSortArray));
		List<Integer> list = Arrays.asList(4, 5, 6, 1, 3, 2);
		Collections.sort(list);
		Arrays.sort(new int[]{4, 5, 6, 1, 3, 2});
	}
}

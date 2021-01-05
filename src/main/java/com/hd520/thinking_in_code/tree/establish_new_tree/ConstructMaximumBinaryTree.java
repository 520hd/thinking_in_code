package com.hd520.thinking_in_code.tree.establish_new_tree;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 创建最大二叉树
 * leetcode 654
 * @Author xierishi
 * @Date 2021-01-05 16:55:12
 */
public class ConstructMaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}
		return constructTree(nums, 0, nums.length - 1);

	}

	private TreeNode constructTree(int[] nums, int start, int end) {

		if (start > end) {
			return null;
		}
		int maxValIndex = findMaxIndex(nums, start, end);
		TreeNode root = new TreeNode(nums[maxValIndex]);
		root.left = constructTree(nums, start, maxValIndex - 1);
		root.right = constructTree(nums, maxValIndex + 1, end);
		return root;

	}

	private int findMaxIndex(int[] nums, int start, int end) {

		int index = -1;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (nums[i] > max) {
				index = i;
				max = nums[i];
			}
		}
		return index;
	}
}

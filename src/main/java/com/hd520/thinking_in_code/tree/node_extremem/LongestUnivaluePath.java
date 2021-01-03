package com.hd520.thinking_in_code.tree.node_extremem;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * leetcode 687. 最长同值路径
 * @Author xierishi
 * @Date 2021-01-03 21:18:10
 */
public class LongestUnivaluePath {

	int max = 0;
	public int longestUnivaluePath(TreeNode root) {

		if (root == null) {
			return 0;
		}
		dfs(root);
		return max;

	}

	private int dfs(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 0;
		}
		int left = root.left != null ? dfs(root.left) + 1 : 0;
		int right = root.right != null ? dfs(root.right) + 1 : 0;
		// 这一步对节点和子节点的值进行判断,若值不相等,将该路径的长度置为0
		if (root.left != null && !root.left.val.equals(root.val)) {
			left = 0;
		}
		if (root.right != null && !root.right.val.equals(root.val)) {
			right = 0;
		}
		max = Math.max(max, left + right);
		return Math.max(left, right);

	}

}

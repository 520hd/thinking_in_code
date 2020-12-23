package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 判断是否是平衡二叉树
 * @Author xierishi
 * @Date 2020-12-24 00:32:29
 */
public class BalanceSearchTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(maxHeight(root.left) - maxHeight(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int maxHeight(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int leftHeight = maxHeight(root.left);
		int rightHeight = maxHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

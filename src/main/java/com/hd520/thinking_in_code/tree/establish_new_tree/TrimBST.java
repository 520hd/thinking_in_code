package com.hd520.thinking_in_code.tree.establish_new_tree;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 修剪二叉搜索树
 * leetcode 669
 * @Author xierishi
 * @Date 2021-01-05 23:25:50
 */
public class TrimBST {

	public TreeNode trimBST(TreeNode root, int low, int high) {

		if (root == null) {
			return null;
		}
		// 根据二叉搜索树的特性，既然根节点已经小于边界，左子树就没有考察的必要了，可以继续考察右子树
		if (root.val < low) {
			return trimBST(root.right, low, high);
		}
		// 根据二叉搜索树的特性，既然根节点已经大于边界，右子树就没有考察的必要了，可以继续考察左子树
		if (root.val > high) {
			return trimBST(root.left, low, high);
		}

		TreeNode node = new TreeNode(root.val);
		node.left = trimBST(root.left, low, high);
		node.right = trimBST(root.right, low, high);
		return node;
	}
}

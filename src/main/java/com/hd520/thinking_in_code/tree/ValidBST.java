package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 验证二叉搜索树的合法性
 * @Author xierishi
 * @Date 2020-12-23 20:44:47
 */
public class ValidBST {

	public boolean isValidBST(TreeNode root) {

		return backtrack(root, null, null);
	}

	/**
	 * 判断二叉搜索树的合法性需要添加一个判断值
	 * 就是左子树的最大值就是根节点root的值
	 * 右子树的最小值就是根节点root的值
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	private boolean backtrack(TreeNode root, TreeNode min, TreeNode max) {

		if (root == null) {
			return true;
		}
		// 对左子树进行判断
		if (min != null && root.val <= min.val) {
			return false;
		}
		// 对右子树进行判断
		if (max != null && root.val >= max.val) {
			return false;
		}

		return backtrack(root.left, min, root) && backtrack(root.right, root, max);
	}

	/**
	 * 这个解法是错的.
	 * @param root
	 * @return
	 */
	private boolean backtrackWrong(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.val <= root.left.val) {
			return false;
		}
		if (root.right != null && root.val >= root.right.val) {
			return false;
		}

		return backtrackWrong(root.left) && backtrackWrong(root.right);
	}
}

package com.hd520.thinking_in_code.tree.node_extremem;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 求二叉树的坡度之和
 * @Author xierishi
 * @Date 2021-01-04 23:16:07
 */
public class FindTilt {

	int tilt = 0;
	public int findTilt(TreeNode root) {
		handle(root);
		return tilt;
	}
	private int handle(TreeNode root) {

		if (root == null) {
			return 0;
		}
		// base case 考察节点的左右子树为叶子节点,则子树和为叶子节点的值
		if (root.right == null && root.left == null) {
			return root.val;
		}
		int left = handle(root.left);
		int right = handle(root.right);
		tilt += Math.abs(left - right);
		// 将子树之和往上传递,计算父节点的坡度
		return root.val + left + right;
	}
}

package com.hd520.thinking_in_code.tree.node_extremem;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

/**
 * @Description 节点最大直径问题
 * 每个节点的最长路径（以节点为中心，左子树边长+右子树边长的最值）
 * leetcode 543. 二叉树的直径
 * @Author xierishi
 * @Date 2021-01-03 20:30:39
 */
public class NodeMaxDiameter {

	int maxDiameter = 0;
	public int diameterOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}
		dfs(root);
		return maxDiameter;
	}

	private int dfs(TreeNode root) {
		if (root.right == null && root.left == null) {
			return 0;
		}
		int left = root.left == null ? 0 : dfs(root.left) + 1;
		int right = root.right == null ? 0 : dfs(root.right) + 1;
		maxDiameter = Math.max(maxDiameter, left + right);
		return Math.max(left, right);

	}

	public static void main(String[] args) {

		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2});
		TreeOperation.show(treeNode);
		NodeMaxDiameter nodeMaxDiameter = new NodeMaxDiameter();
		int diameterOfBinaryTree = nodeMaxDiameter.diameterOfBinaryTree(treeNode);
		System.out.println(diameterOfBinaryTree);

	}
}

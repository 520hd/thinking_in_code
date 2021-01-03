package com.hd520.thinking_in_code.tree.node_extremem;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

/**
 * @Description 二叉树节点的最大路径和
 * leetcode 124. 二叉树中的最大路径和
 * @Author xierishi
 * @Date 2021-01-03 20:45:53
 */
public class NodeMaxPathSum {

	int maxPathSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}
		dfs(root);
		return maxPathSum;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 本题的精髓之一在于这里的处理
		// 子树如果为负数,则可以不包含子树
		int left = Math.max(0, dfs(root.left));
		int right = Math.max(0, dfs(root.right));
		maxPathSum = Math.max(maxPathSum, root.val + left + right);
		return root.val + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{-10,9,20,null,null,15,7});
		TreeOperation.show(treeNode);
		NodeMaxPathSum nodeMaxPathSum = new NodeMaxPathSum();
		int maxPathSum = nodeMaxPathSum.maxPathSum(treeNode);
		System.out.println(maxPathSum);
	}
}

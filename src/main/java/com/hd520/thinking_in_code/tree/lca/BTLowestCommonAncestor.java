package com.hd520.thinking_in_code.tree.lca;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-29 23:03:49
 */
public class BTLowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// base case1 递归至叶子节点返回null
		if (root == null) {
			return null;
		}
		// base case2 递归到的节点等于p/q的节点值,则直接返回该节点
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		// 节点的左右节点均不为空, 则返回根节点
		if (left != null && right != null) {
			return root;
		}
		// 左节点或者右节点有一个不为空则向上传递
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

}

package com.hd520.thinking_in_code.tree.lca;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

/**
 * @Description 二叉搜索树的最近公共祖先问题
 * @Author xierishi
 * @Date 2020-12-29 22:46:20
 */
public class BSTLowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

		if (root == null) {
			return null;
		}
		if (root.val > p && root.val > q) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(root.val < p && root.val < q) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public static void main(String[] args) {
		BSTLowestCommonAncestor bstLowestCommonAncestor = new BSTLowestCommonAncestor();
		TreeNode root = TreeOperation.fromArray(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
		TreeOperation.show(root);
		TreeNode treeNode = bstLowestCommonAncestor.lowestCommonAncestor(root, 4, 5);
		TreeOperation.show(treeNode);
	}

}

package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

/**
 * @Description 子树问题
 * @Author xierishi
 * @Date 2021-01-04 15:07:24
 */
public class ChildTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null) {
			return false;
		}
		return compare(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

	}

	private boolean compare(TreeNode s, TreeNode t) {

		if (s == null) {
			return t == null;
		}
		if (t == null) {
			return s == null;
		}
		if (s.val != t.val) {
			return false;
		}
		return compare(s.left, t.left) && compare(s.right, t.right);
	}

	public static void main(String[] args) {
		TreeNode s = TreeOperation.fromArray(new Integer[]{1,1});
		TreeNode t = TreeOperation.fromArray(new Integer[]{1});
		ChildTree childTree = new ChildTree();
		boolean subtree = childTree.isSubtree(s, t);
		System.out.println(subtree);
	}
}

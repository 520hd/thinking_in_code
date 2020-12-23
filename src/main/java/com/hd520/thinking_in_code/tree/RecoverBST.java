package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

/**
 * @Description 二叉搜索树的恢复(其中有两个数的位置错位了)
 * @Author xierishi
 * @Date 2020-12-23 23:47:49
 */
public class RecoverBST {

	TreeNode first;
	TreeNode last;
	TreeNode pre;
	public void recoverTree(TreeNode root) {

		inOrder(root);
		swap(first, last);
	}

	private void inOrder(TreeNode root) {

		if (root == null) {
			return;
		}
		inOrder(root.left);
		// 如果两个错位的数是相邻的可以直接添加为first和last
		// 如果两个错位的书不是相邻的, 第一个数之前已经添加, 当遍历到第二个数的时候只需要添加last即可
		if (pre != null && pre.val > root.val) {
			if (first == null) {
				first = pre;
			}
			last = root;
		}
		pre = root;
		inOrder(root.right);

	}
	private void swap(TreeNode first, TreeNode last) {
		int temp = first.val;
		first.val = last.val;
		last.val = temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		TreeOperation.show(root);
		RecoverBST recoverBST = new RecoverBST();
		recoverBST.recoverTree(root);
		TreeOperation.show(root);

	}
}

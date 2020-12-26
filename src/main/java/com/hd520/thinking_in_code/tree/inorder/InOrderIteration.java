package com.hd520.thinking_in_code.tree.inorder;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 二叉树中序遍历(迭代版本)
 * @Author xierishi
 * @Date 2020-12-26 15:42:16
 */
public class InOrderIteration {

	private List<Integer> res = new ArrayList<>();
	public List<Integer> inOrder(TreeNode root) {
		TreeNode cur = root;
		LinkedList<TreeNode> stack = new LinkedList<>();
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				res.add(cur.val);
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur = null;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		InOrderIteration inOrderIteration = new InOrderIteration();
		TreeOperation.show(treeNode);
		List<Integer> list = inOrderIteration.inOrder(treeNode);
		System.out.println("res = " + list);
	}
}

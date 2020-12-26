package com.hd520.thinking_in_code.tree.preorder;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 二叉树先序遍历(迭代版)
 * @Author xierishi
 * @Date 2020-12-25 00:25:44
 */
public class PreOrderIteration {

	private List<Integer> res = new ArrayList<>();
    public List<Integer> preOrderTraversal(TreeNode root) {
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				res.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop().right;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		PreOrderIteration preOrderIteration = new PreOrderIteration();
		TreeOperation.show(treeNode);
		List<Integer> list = preOrderIteration.preOrderTraversal(treeNode);
		System.out.println("res = " + list);
	}
}

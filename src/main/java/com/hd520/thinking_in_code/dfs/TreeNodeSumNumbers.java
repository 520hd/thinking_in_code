package com.hd520.thinking_in_code.dfs;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 求根节点到叶子节点的数字之和
 * #129
 * @Author xierishi
 * @Date 2020-12-24 15:53:34
 */
class TreeNodeSumNumbers {

	private List<LinkedList<TreeNode>> res = new ArrayList<>();
 	public int sumNumbers(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();
		backtrack(root, queue);
		int sum = 0;
		for (LinkedList<TreeNode> treeNode : res) {
			StringBuilder sb = new StringBuilder();
			while (!treeNode.isEmpty()) {
				TreeNode temp = treeNode.poll();
				if (temp != null) {
					sb.append(temp.val);
				}
			}
			sum += Integer.parseInt(sb.toString());
		}
		return sum;
	}

	private void backtrack(TreeNode root, LinkedList<TreeNode> queue) {

		// 满足结束条件
		if (root == null) {
			return;
		}
		queue.offer(root);
		if (root.right == null && root.left == null) {
			res.add(new LinkedList<>(queue));
			return;
		}

		// 由于二叉树是不会走重复的路线,因此可以不需要判断是否已走过的路线
		// 对左节点进行回溯, 一定要对节点进行判空
		if (root.left != null) {
			backtrack(root.left, queue);
			queue.removeLast();
		}
		// 对左节点进行回溯, 一定要对节点进行判空
		if (root.right != null) {
			backtrack(root.right, queue);
			queue.removeLast();
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		TreeOperation.show(root);
		TreeNodeSumNumbers solution = new TreeNodeSumNumbers();
		int ret = solution.sumNumbers(root);
		System.out.println(ret);
	}
}

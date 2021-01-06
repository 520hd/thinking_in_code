package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.*;

/**
 * @Description 打印二叉树
 * leetcode 655
 * @Author xierishi
 * @Date 2021-01-05 20:32:26
 */
public class PrintTree {

	List<List<String>> ret = new ArrayList<>();
	public List<List<String>> printTree(TreeNode root) {

		if (root == null) {
			return ret;
		}
		int depth = depth(root);
		int size = (int) Math.pow(2, depth) - 1;
		String[] treeArray = new String[size];
		Arrays.fill(treeArray, "");
		for (int i = 0; i < depth; i++) {
			ret.add(new ArrayList<>(Arrays.asList(treeArray)));
			// 如下是浅拷贝, 会有坑
			// ret.add(Arrays.asList(treeArray));
		}
		handle(root, 0, size - 1, 0);
		return ret;
	}

	/**
	 * 每次递归将pos带上, 往下走pos + 1
	 * @param root
	 * @param start
	 * @param end
	 * @param pos
	 */
	private void handle(TreeNode root, int start, int end, int pos) {
		if (root == null || start > end) {
			return;
		}
		int index = start + (end - start) / 2;
		List<String> strings = ret.get(pos);
		strings.set(index, Integer.toString(root.val));

		handle(root.left, start, index - 1, pos + 1);
		handle(root.right, index + 1, end, pos + 1);

	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = root.left != null ? depth(root.left) + 1 : 1;
		int right = root.right != null ? depth(root.right) + 1 : 1;
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		PrintTree printTree = new PrintTree();
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2});

		List<List<String>> lists = printTree.printTree(treeNode);
		System.out.println(lists);
	}
}

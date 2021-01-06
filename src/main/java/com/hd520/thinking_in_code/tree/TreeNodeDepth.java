package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.*;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-05 20:32:26
 */
public class TreeNodeDepth {

	public List<List<String>> printTree(TreeNode root) {

		if (root == null) {
			return ret;
		}
		totalDepth = depth(root);
		int size = (int) Math.pow(2, totalDepth) - 1;
		String[] treeArray = new String[size];
		Arrays.fill(treeArray, "");
		int count = totalDepth;
		while (count-- > 0) {
			ret.add(new ArrayList<>(Arrays.asList(treeArray)));
			// 如下是浅拷贝,禁用
			ret.add(Arrays.asList(treeArray));
		}
		handle(root, 0, size - 1);
		return ret;
	}

	List<List<String>> ret = new ArrayList<>();
	int totalDepth;
	private void handle(TreeNode root, int start, int end) {
		if (root == null || start > end) {
			return;
		}
		int index = start + (end - start) / 2;
		int depth = depth(root);
		System.out.println(index);
		System.out.println(depth);
		List<String> strings = ret.get(totalDepth - depth);
		System.out.println(strings);
		strings.set(index, Integer.toString(root.val));

		handle(root.left, start, index - 1);
		handle(root.right, index + 1, end);

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
		TreeNodeDepth treeNodeDepth = new TreeNodeDepth();
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2});

		List<List<String>> lists = treeNodeDepth.printTree(treeNode);
		System.out.println(lists);
	}
}

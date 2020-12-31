package com.hd520.thinking_in_code.dfs;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-12-31 14:47:53
 */
public class TreeNodeDFS {

	private List<LinkedList<Integer>> ret = new LinkedList<>();
	private List<LinkedList<Integer>> retNew = new LinkedList<>();
	public List<LinkedList<Integer>> getAllPaths(TreeNode root) {

		if (root == null) {
			return ret;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		backtrack(root, queue);
		return ret;
	}

	public List<LinkedList<Integer>> getAllPathsNew(TreeNode root) {

		if (root == null) {
			return retNew;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		backtrackNew(root, queue);
		return retNew;
	}

	private void backtrack(TreeNode root, LinkedList<Integer> queue) {
		if (root == null) {
			return;
		}
		queue.offer(root.val);
		if (root.left == null && root.right == null) {
			ret.add(new LinkedList<>(queue));
		}
		backtrack(root.left, queue);
		backtrack(root.right, queue);
		queue.removeLast();
	}

	private void backtrackNew(TreeNode root, LinkedList<Integer> queue) {
		if (root == null) {
			return;
		}
		queue.offer(root.val);
		if (root.left == null && root.right == null) {
			retNew.add(new LinkedList<>(queue));
		}
		if (root.left != null) {
			backtrackNew(root.left, queue);
			queue.removeLast();
		}
		if (root.right != null) {
			backtrackNew(root.right, queue);
			queue.removeLast();
		}
		// 其实上下这两种方法得到的结果都是一样的,主要是因为这里运用了队列
		// 队列可以轻松删除队尾的数据
		// backtrack(root.left, queue);
		// backtrack(root.right, queue);
		// queue.removeLast();

	}

	public static void main(String[] args) {
		TreeNodeDFS treeNodeDFS = new TreeNodeDFS();

		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{4, 2, 7, 1, 3, 6, 9});
		TreeOperation.show(treeNode);
		// [[4, 2, 1], [4, 2, 3], [4, 7, 6], [4, 7, 9]]
		List<LinkedList<Integer>> allPaths = treeNodeDFS.getAllPaths(treeNode);
		System.out.println(allPaths);
		// [[4, 2, 1], [4, 2, 3], [4, 7, 6], [4, 7, 9]]
		List<LinkedList<Integer>> allPathsNew = treeNodeDFS.getAllPathsNew(treeNode);
		System.out.println(allPathsNew);
	}
}

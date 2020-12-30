package com.hd520.thinking_in_code.tree.serialize;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 通过先序遍历对二叉树进行序列化和反序列化
 * @Author xierishi
 * @Date 2020-12-30 10:14:29
 */
public class PreOrderSerialize {

	private static final String NULL_STR = "#";
	private List<String> res = new ArrayList<>();

	public List<String> serialize(TreeNode root) {
		handleSerialize(root);
		return res;
	}

	private void handleSerialize(TreeNode root) {
		if (root == null) {
			res.add(NULL_STR);
			return;
		}
		res.add(root.val.toString());
		handleSerialize(root.left);
		handleSerialize(root.right);
	}


	public TreeNode deSerialize(List<String> seList) {
		Queue<String> queue = new LinkedList<>();
		for (String str : seList) {
			queue.offer(str);
		}
		return handleDeSerialize(queue);

	}

	private TreeNode handleDeSerialize(Queue<String> queue) {
		if (queue.isEmpty()) {
			return null;
		}
		String first = queue.poll();
		if (first.equals(NULL_STR)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(first));
		root.left = handleDeSerialize(queue);
		root.right = handleDeSerialize(queue);
		return root;
	}

	public static void main(String[] args) {

		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, null, null, 8, 9});
		PreOrderSerialize preOrderSerialize = new PreOrderSerialize();
		List<String> serializeList = preOrderSerialize.serialize(treeNode);
		System.out.println(serializeList);

		TreeNode treeNode1 = preOrderSerialize.deSerialize(serializeList);
		TreeOperation.show(treeNode1);
	}

}

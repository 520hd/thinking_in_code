package com.hd520.thinking_in_code.tree.serialize;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 通过后续遍历对二叉树进行序列化和反序列化操作
 * @Author xierishi
 * @Date 2020-12-30 14:26:53
 */
public class PostOrderSerialize {

	private List<String> res = new ArrayList<>();
	private static final String NULL_STR = "#";
	public List<String> serialize(TreeNode root) {

		handleSerialize(root);
		return res;
	}

	private void handleSerialize(TreeNode root) {
		if (root == null) {
			res.add(NULL_STR);
			return ;
		}
		handleSerialize(root.left);
		handleSerialize(root.right);
		res.add(root.val.toString());
	}

	public TreeNode deSerialize(List<String> list) {
		LinkedList<String> stack = new LinkedList<>();
		for (String str : list) {
			stack.push(str);
		}
		return handleDeSerialize(stack);

	}

	private TreeNode handleDeSerialize(LinkedList<String> stack) {
		if (stack.isEmpty()) {
			return null;
		}
		String last = stack.pop();
		if (last == null || last.equals(NULL_STR)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(last));
		root.right = handleDeSerialize(stack);
		root.left = handleDeSerialize(stack);
		return  root;
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, null, null, 8, 9});
		TreeOperation.show(treeNode);
		PostOrderSerialize postOrderSerialize = new PostOrderSerialize();
		List<String> list = postOrderSerialize.serialize(treeNode);
		TreeNode deSerializeTreeNode = postOrderSerialize.deSerialize(list);
		TreeOperation.show(deSerializeTreeNode);
	}
}

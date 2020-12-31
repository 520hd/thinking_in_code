package com.hd520.thinking_in_code.tree.serialize;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.Arrays;

/**
 * @Description 二叉搜索树的序列化与反序列化
 * 先用先序遍历就可以得到先序遍历的序列，
 * 然后对其进行排序就可以得到中序遍历的序列，
 * 因此就可以转化为  根据中序遍历和先序遍历进行恢复二叉树
 * @Author xierishi
 * @Date 2020-12-31 22:59:56
 */
public class BinarySearchTreeSerializeWithSort {

	public String serialize(TreeNode root) {

		StringBuilder data = new StringBuilder("");
		preOrder(root, data);
		return data.toString();
	}

	private void preOrder(TreeNode root, StringBuilder data) {

		if (root == null) {
			return;
		}
		if (data.toString().equals("")) {
			data.append(root.val);
		} else {
			data.append(",").append(root.val);
		}
		preOrder(root.left, data);
		preOrder(root.right, data);
	}

	public TreeNode deSerialize(String data) {
		if (data == null || data.equals("")) {
			return null;
		}
		String[] preOrderStr = data.split(",");
		int[] preOrder = new int[preOrderStr.length];
		for (int i = 0; i < preOrderStr.length; i++) {
			preOrder[i] = Integer.parseInt(preOrderStr[i]);
		}
		int[] inOrder = new int[preOrderStr.length];
		System.arraycopy(preOrder, 0, inOrder, 0, preOrderStr.length);
		Arrays.sort(inOrder);
		return recover(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}

	private TreeNode recover(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {

		if (preStart > preEnd) {
			return null;
		}
		int preStartNum = preOrder[preStart];
		TreeNode root = new TreeNode(preStartNum);
		int index = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == preStartNum) {
				index = i;
			}
		}

		root.left = recover(preOrder, inOrder, preStart + 1, index + preStart - inStart, inStart, index - 1);
		root.right = recover(preOrder, inOrder, index + preStart - inStart + 1, preEnd, index + 1, inEnd);
		return root;
	}

	public static void main(String[] args) {
		BinarySearchTreeSerializeWithSort binarySearchTreeSerialize = new BinarySearchTreeSerializeWithSort();
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{5, 3, 7, 2, 4, 6, 8});
		TreeOperation.show(treeNode);
		String serialize = binarySearchTreeSerialize.serialize(treeNode);
		System.out.println(serialize);
		TreeNode deSerialize = binarySearchTreeSerialize.deSerialize(serialize);
		TreeOperation.show(deSerialize);
	}
}

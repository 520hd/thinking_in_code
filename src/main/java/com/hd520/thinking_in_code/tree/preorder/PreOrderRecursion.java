package com.hd520.thinking_in_code.tree.preorder;

import com.hd520.thinking_in_code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树先序遍历(递归版本)
 * @Author xierishi
 * @Date 2020-12-26 22:18:22
 */
public class PreOrderRecursion {

	private List<Integer> res = new ArrayList<>();
	public List<Integer> inOrder(TreeNode root) {

		res.add(root.val);
		inOrder(root.left);
		inOrder(root.right);
		return res;
	}
}

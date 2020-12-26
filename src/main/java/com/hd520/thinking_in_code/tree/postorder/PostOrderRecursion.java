package com.hd520.thinking_in_code.tree.postorder;

import com.hd520.thinking_in_code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树后序遍历(递归版本)
 * @Author xierishi
 * @Date 2020-12-26 22:18:22
 */
public class PostOrderRecursion {

	private List<Integer> res = new ArrayList<>();
	public List<Integer> inOrder(TreeNode root) {

		inOrder(root.left);
		inOrder(root.right);
		res.add(root.val);
		return res;
	}
}

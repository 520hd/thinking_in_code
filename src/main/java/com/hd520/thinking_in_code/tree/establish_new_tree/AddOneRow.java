package com.hd520.thinking_in_code.tree.establish_new_tree;

import com.hd520.thinking_in_code.util.TreeNode;

/**
 * @Description 623. 在二叉树中增加一行
 * @Author xierishi
 * @Date 2021-01-05 00:08:29
 */
public class AddOneRow {

	public TreeNode addOneRow(TreeNode root, int v, int d) {

		if (root == null) {
			return null;
		}
		// 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		// 当d = 2的时候, 就是一种base case 对这个基础case进行处理即可
		if (d == 2) {
			TreeNode l = new TreeNode(v);
			TreeNode r = new TreeNode(v);
			l.left = root.left;
			r.right = root.right;
			root.left = l;
			root.right = r;
			return root;
		}
		// 创建新的二叉树, 只要找到了base case 就可以获得root的左右子树.
		root.left = addOneRow(root.left, v, d - 1);
		root.right = addOneRow(root.right, v, d - 1);
		return root;
	}
}

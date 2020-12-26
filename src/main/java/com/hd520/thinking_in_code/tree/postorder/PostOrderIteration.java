package com.hd520.thinking_in_code.tree.postorder;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.*;

/**
 * @Description 二叉树的后序遍历(其中包括递归和迭代)
 * @Author xierishi
 * @Date 2020-12-25 09:14:08
 */
public class PostOrderIteration {

	public List<Integer> postOrderTraversal(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		TreeNode visited = null;
		while(!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}else {
				cur = stack.peek();
				if (cur.right == null || cur.right == visited) {
					res.add(cur.val);
					stack.pop();
					// 将visited指向当前节点, 当下次进来的时候判断cur.right == visited
					// 不让父节点再往右节点走
					visited = cur;
					// 其中将cur置为null是不让父节点再往左节点走
					cur = null;
				} else {
					cur = cur.right;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		PostOrderIteration postOrderIteration = new PostOrderIteration();
		TreeOperation.show(treeNode);
		List<Integer> list = postOrderIteration.postOrderTraversal(treeNode);
		System.out.println("res = " + list);
	}

}

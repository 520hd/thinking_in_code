package com.hd520.thinking_in_code.tree;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author xierishi
 * @Date 2021-01-05 22:57:53
 */
public class WidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {

		TreeNode node = handle(root, 1);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		TreeOperation.show(node);
		int max = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int minIndex = 0;
			int maxIndex = 0;
			int count = size;
			while (count > 0) {
				TreeNode first = queue.poll();

				if (first.left != null) {
					queue.offer(first.left);
				}
				if (first.right != null) {
					queue.offer(first.right);
				}
				if (count == size) {
					minIndex = first.val;
				}
				if (count == 1) {
					maxIndex = first.val;;
				}
				count--;
			}
			max = Math.max(max, maxIndex - minIndex + 1);
		}
		return max;
	}

	private TreeNode handle(TreeNode root, int index) {
		if (root == null) {
			return null;
		}
		TreeNode newRoot = new TreeNode(index);
		newRoot.left = handle(root.left, index * 2);
		newRoot.right = handle(root.right, index * 2 + 1);
		return newRoot;
	}


	private int maxW = 0;
	public int widthOfBinaryTreeNew(TreeNode root) {
		/**
		 假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
		 用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
		 节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
		 加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
		 **/
		dfs(root, 1, 1, new ArrayList<>());
		return maxW;
	}

	private void dfs(TreeNode r, int level, int index, List<Integer> left) {
		if(r == null) return;
		if(level > left.size()) left.add(index);
		maxW = Math.max(maxW, index - left.get(level-1) + 1);
		dfs(r.left, level+1, index*2, left);
		dfs(r.right, level+1, index*2+1, left);
	}

	public static void main(String[] args) {
		WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 3, 2, 5, 3, null, 9});

		int ret = widthOfBinaryTree.widthOfBinaryTree(treeNode);
		System.out.println(ret);
	}
}

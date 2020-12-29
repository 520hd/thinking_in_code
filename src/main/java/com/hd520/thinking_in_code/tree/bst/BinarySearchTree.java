package com.hd520.thinking_in_code.tree.bst;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

/**
 * @Description 二叉搜索树专辑
 * @Author xierishi
 * @Date 2020-12-28 23:11:03
 */
public class BinarySearchTree {

	/**
	 * 判断二叉树是否是二叉搜索树
	 * @param root
	 * @return
	 */
	public boolean isBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBSTValid(root, null, null);

	}

	private boolean isBSTValid(TreeNode root, TreeNode min, TreeNode max) {

		if (root == null) {
			return true;
		}
		if (min != null && root.val < min.val) {
			return false;
		}
		if (max != null && root.val > max.val) {
			return false;
		}
		return isBSTValid(root.left, min, root) && isBSTValid(root.right, root, max);
	}

	/**
	 * 判断一个数是否存在于二叉搜索树中
	 * @param root
	 * @param target
	 * @return
	 */
	public boolean isInBST(TreeNode root, int target) {

		if (root == null) {
			return false;
		}
		if (root.val == target) {
			return true;
		}
		// 这个是二叉树返回布尔型的标准返回, 但是这个是搜索二叉树中是否存在目标值, 只需要一遍存在即可
		// return isInBST(root.left, target) || isInBST(root.right, target);
		if (root.val > target) {
			return isInBST(root.left, target);
		}
		return isInBST(root.right, target);
	}

	/**
	 * 往二叉搜索树中插入一个数
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val == val) {
			return root;
		}
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		}
		if (root.val < val) {
			root.right = insertIntoBST(root.right, val);
		}
		return root;
	}


	public TreeNode deleteNodeFromBST(TreeNode root, int val) {

		if (root == null) {
			return null;
		}
		// 当找到了指定的节点
		if (root.val == val) {
			// 当该节点为末尾节点既没有左节点也没有有节点
			if (root.left == null && root.right == null) {
				return null;
			}
			// 当只有左节点的时候
			if (root.left != null && root.right == null) {
				return root.left;
			}
			// 当只有右节点的时候
			if (root.left == null && root.right != null) {
				return root.right;
			}
			if (root.left != null && root.right != null) {
				// 当目标的节点既有左子树也有右子树
				// 需要获取右子树的最小节点,用来代替该节点
				TreeNode min = getMinNode(root.right);
				int minVal = min.val;
				root.val = minVal;
				root.right = deleteNodeFromBST(root.right, minVal);
			}

		}
		if (root.val > val) {
			root.left = deleteNodeFromBST(root.left, val);
		}
		if (root.val < val) {
			root.right = deleteNodeFromBST(root.right, val);
		}
		return root;
	}

	/**
	 * 获取到二叉搜索树的最小节点(即最右侧的节点)
	 * @param cur
	 * @return
	 */
	private TreeNode getMinNode(TreeNode cur) {
		if (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}

	public static void main(String[] args) {
		TreeNode root = TreeOperation.fromArray(new Integer[]{5, 3, 7, 2, 4, 6, 8});
		TreeOperation.show(root);
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		boolean isBst = binarySearchTree.isBST(root);
		System.out.println(isBst);
		boolean inBST = binarySearchTree.isInBST(root, 6);
		System.out.println(inBST);

		TreeNode treeNode = binarySearchTree.deleteNodeFromBST(root, 5);
		TreeOperation.show(treeNode);
	}
}

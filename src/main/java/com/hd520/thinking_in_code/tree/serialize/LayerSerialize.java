package com.hd520.thinking_in_code.tree.serialize;

import com.hd520.thinking_in_code.util.TreeNode;
import com.hd520.thinking_in_code.util.TreeOperation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 通过分层遍历进行二叉树的序列化与反序列化操作
 * @Author xierishi
 * @Date 2020-12-30 15:04:22
 */
public class LayerSerialize {

	private List<String> list = new ArrayList<>();
	private static final String NULL_STR = "#";
	public List<String> serialize(TreeNode root) {
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode first = queue.poll();
				if (first == null) {
					list.add(NULL_STR);
					continue;
				} else {
					list.add(first.val.toString());
				}
				queue.offer(first.left);
				queue.offer(first.right);
			}
		}
		return list;
	}

	public TreeNode deSerialize(List<String> list) {
		if (list == null || list.size() == 0) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
		queue.offer(root); // 队列中存储的都是父节点

		for (int i = 1; i < list.size(); i++) {
			TreeOperation.show(root);
			int size = queue.size();
			while (size-- > 0) {
				TreeNode parent = queue.poll();
				if (parent == null) {
					continue;
				}
				String leftStr = list.get(i++);
				if (leftStr == null || leftStr.equals(NULL_STR)) {
					parent.left = null;
				} else {
					TreeNode left = new TreeNode(Integer.parseInt(leftStr));
					parent.left = left;
					queue.offer(left);
				}
				String rightStr = list.get(i++);
				if (rightStr == null || rightStr.equals(NULL_STR)) {
					parent.right = null;
				} else {
					TreeNode right = new TreeNode(Integer.parseInt(rightStr));
					parent.right = right;
					queue.offer(right);
				}
			}
			i--;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode treeNode = TreeOperation.fromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, null, null, 8, 9});
		TreeOperation.show(treeNode);
		LayerSerialize layerSerialize = new LayerSerialize();
		List<String> serializeList = layerSerialize.serialize(treeNode);
		System.out.println(serializeList);
		TreeNode deSerialize = layerSerialize.deSerialize(serializeList);
		TreeOperation.show(deSerialize);

	}
}

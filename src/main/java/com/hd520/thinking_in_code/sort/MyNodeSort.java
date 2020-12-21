package com.hd520.thinking_in_code.sort;


import com.hd520.thinking_in_code.linkedList.MyNode;

/**
 * @Description 基于链表的
 * @Author xierishi
 * @Date 2020-08-03 10:35:31
 */
public class MyNodeSort {

	public static MyNode<Integer> myBubbleSort(MyNode<Integer> originalNode) {

		if (originalNode == null || originalNode.getNext() == null) {
			return originalNode;
		}
		MyNode<Integer> dumNode = MyNode.createNode(0);
		dumNode.setNext(originalNode);
		MyNode<Integer> pre = dumNode.getNext();

		// 运用双指针进行运行
		while(pre != null) {
			MyNode<Integer> next = pre.getNext();
			while (next != null) {
				if (next.getData() < pre.getData()) {
					Integer temp = pre.getData();
					pre.setData(next.getData());
					next.setData(temp);
				}
				next = next.getNext();
			}
			pre = pre.getNext();
		}
		return dumNode.getNext();
	}

	public static void main(String[] args) {

		MyNode<Integer> originalNode = initEvenNumberNode();
		MyNode<Integer> afterBubbleSort = myBubbleSort(originalNode);
		System.out.println(afterBubbleSort.toMyString());

	}

	private static MyNode<Integer> initEvenNumberNode(){
		MyNode<Integer> head = null;
		MyNode<Integer> cur = null;
		for (int i = 10; i > 0; i = i - 2) {
			MyNode<Integer> node = MyNode.createNode(i);
			if (head == null) {
				head = node;
				cur = head;
			} else {
				cur.setNext(node);
				cur = node;
			}
		}
		System.out.println(head.toMyString());
		return head;
	}
}

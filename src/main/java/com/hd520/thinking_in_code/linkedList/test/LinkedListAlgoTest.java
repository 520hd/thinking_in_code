package com.hd520.thinking_in_code.linkedList.test;


import com.hd520.thinking_in_code.linkedList.LinkedListAlgo;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-07-19 15:37:32
 */
public class LinkedListAlgoTest {

	public static void main(String[] args) throws IllegalAccessException {

		// 测试单向链表反转
//		testReverseNode();
		// 测试链表中环检测
//		testCheckNodeCycle();
		// 测试有序链表合并
		testMergeSortedNodes(initOddNumberNode(), initEvenNumberNode());

		testDeleteLastNth(initEvenNumberNode(), 2);

		testDeleteLastKth(initEvenNumberNode(), 2);

		testFindMiddleNode(initEvenNumberNode());
	}

	private static void testFindMiddleNode(LinkedListAlgo.Node originalNode) {

		LinkedListAlgo.Node middleNode = LinkedListAlgo.findMiddleNode(originalNode);
		System.out.println(middleNode.toMyString());
	}

	private static void testDeleteLastKth(LinkedListAlgo.Node initEvenNumberNode, int i) {
		LinkedListAlgo.Node node = LinkedListAlgo.deleteLastKth(initEvenNumberNode, i);
		System.out.println(node.toMyString());

	}

	private static void testDeleteLastNth(LinkedListAlgo.Node originalNode, int i) throws IllegalAccessException {
		LinkedListAlgo.Node handledNode = LinkedListAlgo.deleteLastNth(originalNode, i);
		System.out.println(handledNode.toMyString());

	}

	private static void testMergeSortedNodes(LinkedListAlgo.Node oddNumberNode, LinkedListAlgo.Node evenNumberNode) {

		LinkedListAlgo.Node mergeSortedNodes = LinkedListAlgo.mergeSortedLists(oddNumberNode, evenNumberNode);
		System.out.println(mergeSortedNodes.toMyString());
	}

	private static void testReverseNode(){

		LinkedListAlgo.Node originalNode = initNormalNode();
		System.out.println(originalNode.toMyString());
		LinkedListAlgo.Node reverseNode = LinkedListAlgo.reverseNode(originalNode);
		System.out.println(reverseNode.toMyString());
	}

	private static void testCheckNodeCycle(){
		LinkedListAlgo.Node abnormalNode = initAbnormalNode();
		boolean checkAbnormalNodeCycle = LinkedListAlgo.checkNodeCycle(abnormalNode);
		System.out.println(checkAbnormalNodeCycle);
		LinkedListAlgo.Node normalNode = initNormalNode();
		boolean checkNormalNodeCycle = LinkedListAlgo.checkNodeCycle(normalNode);
		System.out.println(checkNormalNodeCycle);
	}

	private static LinkedListAlgo.Node initAbnormalNode(){

		LinkedListAlgo.Node head = null;
		LinkedListAlgo.Node cur = null;
		LinkedListAlgo.Node cycleNode = null;
		for (int i = 1; i <= 5; i++) {
			LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, null);
			if (i == 3) {
				cycleNode = head;
			}
			if (head == null) {
				head = node;
				cur = head;
			} else {
				cur.setNext(node);
				cur = node;
			}
		}
		head.setNext(cycleNode);
		return head;


	}

	private static LinkedListAlgo.Node initNormalNode(){

		LinkedListAlgo.Node head = null;
		LinkedListAlgo.Node cur = null;
		for (int i = 1; i <= 5; i++) {
			LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, null);
			if (head == null) {
				head = node;
				cur = head;
			} else {
				cur.setNext(node);
				cur = node;
			}
		}
		return head;
	}

	private static LinkedListAlgo.Node initOddNumberNode(){
		LinkedListAlgo.Node head = null;
		LinkedListAlgo.Node cur = null;
		for (int i = 1; i <= 10; i = i+2) {
			LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, null);
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

	private static LinkedListAlgo.Node initEvenNumberNode(){
		LinkedListAlgo.Node head = null;
		LinkedListAlgo.Node cur = null;
		for (int i = 2; i <= 16; i = i+2) {
			LinkedListAlgo.Node node = new LinkedListAlgo.Node(i, null);
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

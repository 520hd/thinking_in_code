package com.hd520.thinking_in_code.linkedList;

/**
 * @Description 单链表反转
 * 链表中环的检测
 * 两个有序的链表合并
 * 删除链表倒数第 n 个结点
 * 求链表的中间结点
 * @Author xierishi
 * @Date 2020-07-04 11:49:45
 */
public class LinkedListAlgo {

	/**
	 * 单向链表反转
	 * 第一种方法,就是原地反转
	 *
	 * @param originalNode
	 * @return
	 */
	public static Node reverseNode(Node originalNode) {

		if (originalNode == null || originalNode.next == null) {
			return originalNode;
		}
		// 令新的链表为pre
		Node pre = originalNode;
		Node cur = originalNode.next; // cur作为迭代的指针
		pre.next = null;
		// 迭代到尾结点的判断
		while (cur != null) {
			// 将指针的下一个节点暂存起来,给指针cur偏移使用
			Node curNext = cur.next;
			cur.next = pre;
			pre = cur;
			cur = curNext;
		}
		return pre;
	}

	/**
	 * 链表中环检测
	 * 利用快慢指针的方法进行检测
	 * 1)如果没有环的话快指针肯定先遍历完链表
	 * 2)如果链表中有环的话两个指针肯定会在某个时刻相遇
	 * @param waitingCheckNode
	 * @return
	 */
	public static boolean checkNodeCycle(Node waitingCheckNode) {
		if (waitingCheckNode == null || waitingCheckNode.next == null || waitingCheckNode.next.next == null) {
			return false;
		}

		Node lowCounter = waitingCheckNode;
		Node fastCounter = waitingCheckNode.next;
		while (fastCounter != null && fastCounter.next != null) {
			lowCounter = lowCounter.next;
			fastCounter = fastCounter.next.next;
			if (lowCounter == fastCounter) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 有序链表的合并
	 * 方法1: 暴力合并
	 * @param sortedNode1
	 * @param sortedNode2
	 * @return
	 */
	public static Node mergeSortedLists(Node sortedNode1, Node sortedNode2) {
		if (sortedNode1 == null) {
			return sortedNode2;
		}
		if (sortedNode2 == null) {
			return sortedNode1;
		}
		// 引入一个哨兵节点
		Node soldierNode = createNode(0);

		Node cur1 = sortedNode1;
		Node cur2 = sortedNode2;
//		if (cur1.data < cur2.data) {
//			mergeNode = cur1;
//			cur1 = cur1.next;
//		} else {
//			mergeNode = cur2;
//			cur2 = cur2.next;
//		}
		// 引入一个指针移动指针r
		// 需要理解指针的概念: 将某个变量赋值给指针，实际上就是将这个变量的地址赋值给指针，或者反过来说，指针中存储了这个变量的内存地址，指向了这个变量，通过指针就能找到这个变量。
		Node r = soldierNode;
		while (cur1 != null && cur2 != null) {
			if (cur1.data < cur2.data) {
				// 操作r指向cur1
				r.next = cur1;
				cur1 = cur1.next;
			}else {
				// 操作r指向cur2
				r.next = cur2;
				cur2 = cur2.next;
			}
			// 需要将指针往后偏移一位
			r = r.next;
		}
		if (cur2 == null) {
			r.next = cur1;
		}
		if (cur1 == null) {
			r.next = cur2;
		}

		System.out.println(r.toMyString());
		return soldierNode.next;

	}

	/**
	 * 删除链表倒数第N个节点
	 * @param originalNode
	 * @param n
	 * @return
	 */
	public static Node deleteLastNth(Node originalNode, int n) throws IllegalAccessException {

		if (originalNode == null) {
			return null;
		}
		if (n <= 0) {
			throw new IllegalAccessException("您输入的倒数第N个节点数必须为正整数");
		}
		int nodeLength = 0;
		Node lengthNode = originalNode;
		while(lengthNode != null) {
			nodeLength++;
			lengthNode = lengthNode.next;
		}

		if (n > nodeLength) {
			throw new IllegalAccessException("您输入的倒数第N个节点数已经超过链表的长度了");
		}
		if (n == nodeLength) {
			return originalNode.next;
		}
		int firstNode = nodeLength - n;
		Node cur = originalNode;
		while (firstNode > 0 ) {

			Node next = cur.next;
			if (--firstNode == 0) {
				cur.next = next.next;
			}
			cur = cur.next;
		}
		return originalNode;
	}


	/**
	 * 删除倒数第K个节点
	 * 也可以理解为运用快慢指针,快指针先运行到正数第K个节点然后等待满指针
	 * 之后两个指针一起运行,待快指针到达尾结点的时候,这时满指针到达倒数第K个节点,可以开始操作
	 * @param list
	 * @param k
	 * @return
	 */
	public static Node deleteLastKth(Node list, int k) {
		Node fast = list;
		int i = 1;
		while (fast != null && i < k) {
			fast = fast.next;
			++i;
		}

		if (fast == null) return list;

		Node slow = list;
		Node prev = null;
		while (fast.next != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}

		if (prev == null) {
			list = list.next;
		} else {
			prev.next = prev.next.next;
		}
		return list;
	}

	/**
	 * 求中间节点
	 * 也可以运用快慢指针进行求解
	 * 快指针运用两倍速进行移动而慢指针以正常速度移动
	 * 待快指针到达尾结点的时候慢指针刚好到达中间节点
	 * @return
	 */
	public static Node findMiddleNode(Node originalNode){
		if (originalNode == null || originalNode.next == null) {
			return originalNode;
		}

		Node fast = originalNode;
		Node slow = originalNode;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("originalNode= " + originalNode.toMyString());
		return slow;
	}


	public static Node createNode(int value) {

		return new Node(value, null);
	}

	public static class Node {

		private int data;
		private Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toMyString() {
			Node newNode = this;
			Node nextNode = newNode.next;
			if (nextNode == null) {
				return String.valueOf(newNode.data);
			}
			StringBuilder sb = new StringBuilder(String.valueOf(newNode.data));

			while (nextNode != null) {
				sb.append("-->");
				sb.append(nextNode.data);
				nextNode = nextNode.next;
			}
			return sb.toString();
		}

		@Override
		public String toString() {
			return "Node{" +
					"data=" + data +
					", next=" + next +
					'}';
		}
	}
}

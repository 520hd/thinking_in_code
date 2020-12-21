package com.hd520.thinking_in_code.linkedList;

/**
 * @Description
 * @Author xierishi
 * @Date 2020-07-26 15:59:28
 */
public class MyNode<T> {

	private T data;
	private MyNode<T> next;

	public MyNode(T data, MyNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public void setNext(MyNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public MyNode<T> getNext() {
		return next;
	}

	public static <T> MyNode<T> createNode(T data){
		return new MyNode<>(data, null);
	}

	public String toMyString() {
		MyNode newNode = this;
		MyNode nextNode = newNode.next;
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

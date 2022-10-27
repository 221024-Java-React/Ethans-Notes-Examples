package com.example.generics;

public class Node<T> {
	
	//Each node needs some info/data, we are using T as the placeholder for the data
	//Generic data being held by the list node
	private T data;
	//The reference to the next node
	private Node<T> next;
	
	public Node(T data) {
		//When we create a node on a linked list, there will be no link to the next
		this.data = data;
		this.next = null;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}
}

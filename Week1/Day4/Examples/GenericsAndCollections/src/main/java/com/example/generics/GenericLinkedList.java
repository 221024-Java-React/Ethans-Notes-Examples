package com.example.generics;

/*Generics allow us to make a placeholder for our objects */
public class GenericLinkedList<T> {
	
	//We also need some info inside of the list
	public int length;
	private Node<T> head;
	
	public GenericLinkedList() {
		this.length = 0;
		this.head = null;
	}
	
	//The most basic methods for a linked list include, add(T data), remove(int index), get(int index)
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		
		//We first want to see if the list is empty, if it is, we will set the node we just created as the head
		if(this.head == null) {
			this.head = node;
		} else {
			//Otherwise, we want to loop until we find null, and set the next value of the last node, to the node
			//we just created
			Node<T> n = this.head;
			while(n.getNext() != null) {
				n = n.getNext();
			}
			
			n.setNext(node);
		}
		
		length++;
	}
	
	public void remove(int index) {
		
		//if the index is 0, we just set the head to be the next node
		if(index == 0) {
			this.head = this.head.getNext();
		}
        //If the index is between 1 and n-1 where n is the last node in the list, we want to simply point the previous node at the node after the one we want to remove
        //So we want to start at the head and loop until one before the node we want to remove
        //When we get to the index before the one we want to remove, when need to store it in a variable
        //Then we need to move forward two nodes and save that node in a variable
        //Finally we need to point the node from above at the second node from above
        //If the node we want to remove is the final node, next will be equal to null, and we can check for that,
        //If it is the last node, we can just go backwards one node and set next to null
		else {
			//Start at the head
			Node<T> n = head;
			//Loop until index-1 and save that in a variable
			for(int i=0; i<index-1; i++) {
				try {
					n = n.getNext();
					if(n.getNext() == null) throw new NullPointerException();
				} catch (NullPointerException e) {
					throw new IndexOutOfBoundsException();
				}
			}
			
			//Temporarily store the node before the one we are deleting
			Node<T> n1 =  n;
			
			//Get the node after the one we want to delete
			Node<T> n2 = n.getNext().getNext();
			
			//Otherwise point n1 at n2
			n1.setNext(n2);
			
			length--;
		}
	}
	
	//We want to retrieve an element by its index, all we need to do is loop until we get to that index
	public T get(int index) {
		if(index == 0) {
			return head.getData();
		}
		else {
			Node<T> n = head;
			for(int i=0; i<index; i++) {
				try {
					n = n.getNext();
					if(n == null) throw new NullPointerException();
				} catch (NullPointerException e) {
					throw new IndexOutOfBoundsException();
				}
			}
			return n.getData();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Linked List: {\n");
		Node<T> n = head;
		while(n != null) {
			sb.append(n.getData() + ",");
			n = n.getNext();
		}
		sb.append("\n}");
		return sb.toString();
	}
}

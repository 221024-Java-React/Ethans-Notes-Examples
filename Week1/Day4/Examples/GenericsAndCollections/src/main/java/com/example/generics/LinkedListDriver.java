package com.example.generics;

public class LinkedListDriver {

	public static void main(String[] args) {
		GenericLinkedList<Integer> ll = new GenericLinkedList<Integer>();
		ll.add(5);
		System.out.println(ll.toString());
		ll.add(7);
		System.out.println(ll.toString());
		ll.add(3);
		System.out.println(ll.toString());
		ll.add(4);
		System.out.println(ll.toString());
		
		/*
		ll.remove(4);
		System.out.println(ll.toString());
		*/
		System.out.println(ll.get(2));
	}

}

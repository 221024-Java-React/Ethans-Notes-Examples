package com.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionsDriver {
	
	public static void main(String args[]) {
		/* Collections API Data structures */
		//LinkedList
		
		List<Integer> numberLinkedList = new LinkedList<>();
		
		//There are also many other LinkedList methods you can see by looking here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
		//Add items to our linkedlist
		numberLinkedList.add(100);
		numberLinkedList.add(54);
		numberLinkedList.add(3);
		numberLinkedList.add(87);
		
		//ArrayList<Integer> castingALinkedList = (ArrayList) numberLinkedList;
		//System.out.println(numberLinkedList);
		
		//Iterators allow us to loop/iterate through a datastructure such as a linked list
		//We must get the iterator from the data structure
		Iterator<Integer> iterator = numberLinkedList.iterator();
		
		System.out.println("Looping through our linked list with an iterator");
		while(iterator.hasNext()) {
			//.next() will literally move to the next position in the datastructure
			System.out.println(iterator.next());
		}
		
		//Arraylist
        //There are many other ArrayList methods you can see by looking here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
		List<Integer> numberArrayList = new ArrayList<>();		
		
		numberArrayList.add(5);
		numberArrayList.add(6);
		numberArrayList.add(7);
		numberArrayList.add(8);
		
		numberArrayList.remove(3);
		
		System.out.println("Printing an Arraylist with a simple for loop");
		//We can loop through this similar to any other list
		//To get the amount of items in the list, we use the .size() method
		for(int i=0; i<numberArrayList.size(); i++) {
			//We can get an element from a specific index with .get(int index) method
			System.out.println(numberArrayList.get(i));
		}
		
        //More methods of the HashSet class can be found here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
		//Sets, do not allow for duplicates
		Set<Integer> numberHashSet = new HashSet<>();
		
		//To add values you use the .add() method
		numberHashSet.add(1);
		numberHashSet.add(1);
		numberHashSet.add(2);
		numberHashSet.add(3);
		numberHashSet.add(4);
		
		System.out.println("Printing with an enhanced for loop");
		for(Integer i: numberHashSet) {
			System.out.println(i);
		}
		
		// TreeSet will order the values based off of their "natural" ordering
		//We wont see comparator until week 3, so we will circle back to TreeSet
		
		//The Collections class is a class that holds useful methods for the collections API
		//Collections compares objects which implement the single method from the Comparable interface
		//https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html
		Collections.sort(numberLinkedList);
		Collections.reverse(numberLinkedList);
		
		System.out.println(numberLinkedList);
	}

}

package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.example.models.Student;
import com.example.models.StudentComparator;

public class Driver {
	
	public static void main(String args[]) {
		String classes[] = {"Math", "English", "Science"};
		
	    Student s1 = new Student("Summer", "Smith", classes, 3.0);
	    Student s2 = new Student("Morty", "Smith", classes, 2.3);
	    Student s3 = new Student("Tiny", "Rick", classes, 4.0);
	    Student s4 = new Student("Jessica", "W", classes, 3.6);
		
		//Queues and Deques
		Deque<Student> studentDeque = new ArrayDeque<>();
		
		//To add a student to the front of the queue
		studentDeque.push(s1);
		System.out.println("Deque: " + studentDeque);
		
		//To add a student to the end, we use .add
		studentDeque.add(s2);
		System.out.println("Deque: " + studentDeque);
		
		//Add one more to the front
		studentDeque.push(s3);
		
		//Add one more to back
		studentDeque.add(s4);
		System.out.println("Deque: " + studentDeque);
		
		//To remove from the front, completely removes it from the deque
		//Use this if you are implementing a queue
		Student tinyRick = studentDeque.remove();
		System.out.println("Deque: " + studentDeque);
		
		//To remove from the end, removeLast()
		//Used if implementing a stack
		Student jessica = studentDeque.removeLast();
		System.out.println("Deque: " + studentDeque);
		
        //For more information about what you can do with the Deque look here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html
		
		//Maps, we store info in key value pairs
		//The most popular map is the HashMap<K,V>
		
		Map<String, Student> studentMap = new HashMap<>();
		
		System.out.println("--- MAPS ---");
		
		//To insert data use the .put()
		studentMap.put("Tiny Rick", tinyRick);
		studentMap.put("Jessica", jessica);
		studentMap.put("Summer", s1);
		studentMap.put("Morty", s2);
		
		//To search for a value in the map use the .get("key")
		System.out.println(studentMap.get("Summer"));
		System.out.println(studentMap.get("Bird Person"));
		
		//We cant directly iterate over the values inside of the map, but, we can get iterators to loop
		// over the keys, values, or entries
		Iterator<Student> mapValues = studentMap.values().iterator();
		// The values method returns a straight up Collection
		Collection<Student> mapCollection = studentMap.values();
		
		while(mapValues.hasNext()) {
			System.out.println(mapValues.next());
		}
		
        //For more information on the HashMap class you can look here:
        //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
		
		//A reason to implement the comparable interface is to be used with the Collections class
		//Collections class has utility methods such as sort to be used on datastructures in the Collections API
		
		System.out.println("--- Sorting ---");
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		System.out.println("Pre sorted list: " + students);
		
		Collections.sort(students);
		
		System.out.println("Sorted list: " + students);
		
		//Data structures such as TreeSets will use Comparators to figure out the total ordering of your
		//set
		StudentComparator sComp = new StudentComparator();
		Set<Student> studentTree = new TreeSet(sComp);
		studentTree.add(s1);
		studentTree.add(s2);
		studentTree.add(s3);
		studentTree.add(s4);
		
		System.out.println(studentTree);
		
		
	}
}

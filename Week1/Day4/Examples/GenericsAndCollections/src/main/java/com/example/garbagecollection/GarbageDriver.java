package com.example.garbagecollection;

public class GarbageDriver {

	public static void main(String[] args) {
		System.out.println("Instantiate a new Garbage object");
		Garbage g = new Garbage();
		
		System.out.println("Assign variable g to a differe garbage object");
		g = new Garbage();
		
		//We want to prove that this doesn't immediately destroy the object, even though we suggest to
		System.gc();

		for(;;) {
			System.out.println("Waiting for garbage collection");
		}
	}

}

package com.example.garbagecollection;

public class Garbage {
	//Finalize is a method of the Object class which gets called right before being destroyed
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver called finalize method");
		System.out.println("Goodbye cruel world");
		System.exit(0);
	}

}

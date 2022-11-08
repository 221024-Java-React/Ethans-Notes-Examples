package com.example.lambdas;

//We can use a annotation to tell the compiler that this is a functional interface
@FunctionalInterface
public interface MyFunctionalInterface<T> {
	
	//This singular method will be implemented by lambda expressions
	 T execute();

}

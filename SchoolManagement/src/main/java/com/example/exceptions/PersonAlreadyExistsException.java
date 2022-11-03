package com.example.exceptions;

public class PersonAlreadyExistsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonAlreadyExistsException(){
		super("The person is already registered");
	}
	
}

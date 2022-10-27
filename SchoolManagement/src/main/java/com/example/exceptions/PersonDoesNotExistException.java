package com.example.exceptions;

public class PersonDoesNotExistException extends RuntimeException{
	
	public PersonDoesNotExistException(){
		super("The user you are searching does not exist");
	}

}

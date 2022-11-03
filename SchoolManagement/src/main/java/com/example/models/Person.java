package com.example.models;

import java.io.Serializable;

//To be able to write this to a file, we must mark with it the Serializable interface
public class Person /*implements Serializable*/{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private int id;
	private PersonType type;
	private String firstName;
	private String lastName;
	//If we did not want to write this info to a file, we can mark this property as transient
	//private transient long ssn;
	//private boolean faculty;
	private String email;
	private String password;
	//private double gpa;
	
	//We probably also want to keep track of this person courses, but I can't be bothered right now
	
	public Person() {
		super();
	}

	public Person(int id, PersonType type, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	//Make one other constructor
	public Person(PersonType type, String firstName, String lastName, String email, String password) {
		super();
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", type=" + type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + "]";
	}

}

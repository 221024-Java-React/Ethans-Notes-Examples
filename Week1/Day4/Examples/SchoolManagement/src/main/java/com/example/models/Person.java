package com.example.models;

import java.io.Serializable;

//To be able to write this to a file, we must mark with it the Serializable interface
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	//If we did not want to write this info to a file, we can mark this property as transient
	private transient long ssn;
	private boolean faculty;
	private String email;
	private String password;
	private double gpa;
	
	//We probably also want to keep track of this person courses, but I can't be bothered right now
	
	public Person() {
		super();
	}

	public Person(String firstName, String lastName, long ssn, boolean faculty, String email, String password, double gpa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.faculty = faculty;
		this.email = email;
		this.password = password;
		this.gpa = gpa;
		this.ssn = ssn;
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

	public boolean isFaculty() {
		return faculty;
	}

	public void setFaculty(boolean faculty) {
		this.faculty = faculty;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", faculty=" + faculty + ", email=" + email
				+ ", password=" + password + ", gpa=" + gpa + "]";
	}
}

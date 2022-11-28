package com.example.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//To be able to write this to a file, we must mark with it the Serializable interface
@Entity
//@Table is optional
@Table(name="person")
public class Person /*implements Serializable*/{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//Column is optional, we can just give this column some extra info
	@Column(name="person_id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	private PersonType type;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	//If we did not want to write this info to a file, we can mark this property as transient
	//private transient long ssn;
	//private boolean faculty;
	@Column(unique = true)
	private String email;
	
	private String password;
	//private double gpa;
	
	@OneToMany(mappedBy="teacher", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Course> courses;
	
	//We probably also want to keep track of this person courses, but I can't be bothered right now
	
	public Person() {
		super();
	}

	public Person(int id, PersonType type, String firstName, String lastName, String email, String password, List<Course> courses) {
		super();
		this.id = id;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.courses = courses;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", type=" + type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", courses=" + courses + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, email, firstName, id, lastName, password, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& type == other.type;
	}

}

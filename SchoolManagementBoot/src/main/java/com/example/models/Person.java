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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//To be able to write this to a file, we must mark with it the Serializable interface
@Entity
//@Table is optional
@Table(name="person")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Course> courses;

}

package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Person;

@Repository
@Transactional //Tell spring to manage the transactions, and treat each method as a transaction
public class PersonDaoORM implements PersonDao{
	
	/*
	 * 	ORM - Object Relational Mapper - Converts Java objects to database tables automatically
	 * 	- ORMs let us easily map our models, and it even creates database tables from our java models
	 * 
	 * 	- Abstract away a lot of the JDBC boiler plate code and sessions, and ect
	 * 
	 * 	- There are a lot ORM's JPA and Hibernate are what we will look at quickly
	 * 		- JPA Java Persistence API, set a of interfaces for persisting data in java
	 * 		- Hibernate is an implementation of the JPA API
	 * 	
	 * 	- When we use Hibernate, we use the JPA annotations
	 * 		- Use the @Entity annotation to mark a class as a database table
	 * 		- Use the @Id annotation to mark the field as the id
	 * 		- Use the @Column annotation to give special properties to the column
	 * 		- @ManyToMany @ManyToOne @OneToMany...
	 * 
	 * 	Spring ORM is a way to use Spring with an ORM
	 * 		- It allows spring to manage ORM's, and manage the different operations of an ORM
	 * 
	 */
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public PersonDaoORM(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void addPerson(Person p) throws Exception {
		// Persist a user in the database with hibernate
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public List<Person> getAllPeople() {
		// Use the hibernate query language to select all people
		return sessionFactory.getCurrentSession().createQuery("from Person", Person.class).list();
	}

	@Override
	public Person getPersonByEmail(String email) {
		
		Person p = sessionFactory.getCurrentSession().createQuery("from Person where email =:email", Person.class)
				.setParameter("email", email)
				.getSingleResult();
		
		return p;
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		//Select a person by their id
		return sessionFactory.getCurrentSession().get(Person.class, id);
	}

	@Override
	public void deletePerson(String email) {
		sessionFactory.getCurrentSession().delete(getPersonByEmail(email));
		
	}

	@Override
	public void updatePerson(Person p) {
		sessionFactory.getCurrentSession().update(p);
		
	}

}

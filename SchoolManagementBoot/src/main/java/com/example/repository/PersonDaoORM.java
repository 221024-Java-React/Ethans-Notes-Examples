package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Person;
import com.example.util.HibernateConfig;

@Repository
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
	

	@Override
	public void addPerson(Person p) throws Exception {
		// Persist a user in the database with hibernate
		Session ses = HibernateConfig.getSession();
		
		Transaction t = ses.beginTransaction();
		ses.save(p);
		
		t.commit();
	}

	@Override
	public List<Person> getAllPeople() {
		// Use the hibernate query language to select all people
		Session ses = HibernateConfig.getSession();
		return ses.createQuery("from Person", Person.class).list();
	}

	@Override
	public Person getPersonByEmail(String email) {
		
		Session ses = HibernateConfig.getSession();
		
		Person p = ses.createQuery("from Person where email =:email", Person.class)
				.setParameter("email", email)
				.getSingleResult();
		
		return p;
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		//Select a person by their id
		Session ses = HibernateConfig.getSession();
		return ses.get(Person.class, id);
	}

	@Override
	public void deletePerson(String email) {
		Session ses = HibernateConfig.getSession();
		Transaction t = ses.beginTransaction();
		ses.delete(getPersonByEmail(email));
		t.commit();
	}

	@Override
	public void updatePerson(Person p) {
		Session ses = HibernateConfig.getSession();
		Transaction t = ses.beginTransaction();
		ses.update(p);
		t.commit();
		
	}

}

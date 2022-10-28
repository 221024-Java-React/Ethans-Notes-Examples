package com.example.services;

import java.util.List;

import com.example.dao.PersonDao;
import com.example.exceptions.PersonDoesNotExistException;
import com.example.models.Person;
import com.example.utils.LoggingUtil;

public class PersonService {
	
	private PersonDao personDao;
	
	//Dependency injection, more on this later, just know, it allows us to change components of the same "type"
	//easily
	
	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public void registerPerson(Person p) {
		try {
			personDao.getPersonByEmail(p.getEmail());
			//Throw an exception if the user exists when trying to register
			LoggingUtil.getLogger().warn("User with email " + p.getEmail() + " tried registering again");
		} catch (PersonDoesNotExistException e) {
			personDao.addPerson(p);
			LoggingUtil.getLogger().info("New user registed");
		}
	
	}
	
	public Person login(String email) {
		Person p = personDao.getPersonByEmail(email);
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			return null;
		}
		
		
		LoggingUtil.getLogger().info("User " + email + " logged in");
		return p;
	}
	
	public List<Person> getAllRegistered(){
		return personDao.getAllPeople();
	}

}

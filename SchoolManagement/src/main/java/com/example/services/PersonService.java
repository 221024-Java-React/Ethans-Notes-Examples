package com.example.services;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.PersonDao;
import com.example.exceptions.PersonAlreadyExistsException;
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
			personDao.addPerson(p);
			LoggingUtil.getLogger().warn("User: " + p + " was registered");
		} catch(Exception e) {
			LoggingUtil.getLogger().warn("User with email " + p.getEmail() + " tried to register a second time");
			throw new PersonAlreadyExistsException();
		}
		
	}
	
	public Person login(String email) {
		Person p = personDao.getPersonByEmail(email);
		
		if(p == null) {
			LoggingUtil.getLogger().warn("User with email " + email + " had a failed login attempt");
			
			//Instead of returning null, we could throw an exception and allow Javalin to send a custom response
			throw new PersonDoesNotExistException();
		}
		
		//insert validation logic here
		//p = new Person();
		
		LoggingUtil.getLogger().info("User " + email + " logged in");
		return p;
	}
	
	public List<Person> getAllRegistered(){
		return personDao.getAllPeople();
	}
	
	public void removePerson(String email) {
		personDao.deletePerson(email);
		LoggingUtil.getLogger().info("User " + email + " was removed from the system");
	}
	
	public void updatePerson(Person p) {
		personDao.updatePerson(p);
		LoggingUtil.getLogger().info("User " + p.getId() + " was successfully updated in the system");
	}

}

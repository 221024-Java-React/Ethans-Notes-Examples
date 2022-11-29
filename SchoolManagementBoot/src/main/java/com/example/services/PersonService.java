package com.example.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.PersonDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.PersonAlreadyExistsException;
import com.example.models.Person;

@Service
public class PersonService {
	
	private PersonDao personDao;
	
	//Dependency injection, more on this later, just know, it allows us to change components of the same "type"
	//easily
	
	@Autowired
	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public void registerPerson(Person p) {
		try {
			personDao.addPerson(p);
		} catch(Exception e) {
			throw new PersonAlreadyExistsException();
		}
		
	}
	
	public Person login(String email, String password) {
		Person p = personDao.getPersonByEmail(email);
		
		if(p == null || !p.getPassword().equals(password)) {
			
			//Instead of returning null, we could throw an exception and allow Javalin to send a custom response
			throw new InvalidCredentialsException();
		}
		
		//insert validation logic here
		//p = new Person();
		
		return p;
	}
	
	public List<Person> getAllRegistered(){
		return personDao.getAllPeople();
	}
	
	public void removePerson(int id) {
		String email = personDao.getPersonById(id).getEmail();
		personDao.deletePerson(email);
	}
	
	public void updatePerson(Person p) {
		personDao.updatePerson(p);
	}
	
	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}

}

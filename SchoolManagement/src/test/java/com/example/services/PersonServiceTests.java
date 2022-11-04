package com.example.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.dao.PersonDao;
import com.example.exceptions.PersonAlreadyExistsException;
import com.example.exceptions.PersonDoesNotExistException;
import com.example.models.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTests {
	
	PersonService personService;
	@Mock
	PersonDao personDao;
	
	@Before
	public void setPersonService() {
		personService = new PersonService(personDao);
	}
	
	@Test
	public void testGetAllRegistered() {
		List<Person> testList = new ArrayList<>();
		testList.add(new Person());
		testList.add(new Person());
		
		when(personDao.getAllPeople()).thenReturn(testList);
		
		List<Person> resultList = personService.getAllRegistered();
		
		assertEquals(testList, resultList);
	}
	
	@Test
	public void testLoginValid() {
		Person p = new Person();
		
		when(personDao.getPersonByEmail(anyString())).thenReturn(p);
		
		Person resultPerson = personService.login("email");
		
		assertEquals(p, resultPerson);
	}
	
	@Test
	public void testLoginInvalid() {
		when(personDao.getPersonByEmail(anyString())).thenReturn(null);
		
		assertThrows(PersonDoesNotExistException.class, ()->personService.login("bad email"));
	}
	
	@Test
	public void testRegisterFails() throws Exception{
		doThrow(new SQLException()).when(personDao).addPerson(any(Person.class));
		
		assertThrows(PersonAlreadyExistsException.class, 
				()->personService.registerPerson(new Person()));
		
	}
	
	@Test
	public void testRegisterAddsPerson() {
		Person testPerson = new Person();
		
		personService.registerPerson(testPerson);
		
		try {
			verify(personDao).addPerson(testPerson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}

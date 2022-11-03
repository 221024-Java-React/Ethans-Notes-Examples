package com.example.dao;

import java.util.List;

import com.example.models.Person;

public interface PersonDao {
	
	public void addPerson(Person p);
	public List<Person> getAllPeople();
	public Person getPersonByEmail(String email);
	public void deletePerson(String email);
	public void updatePerson(Person p);

}

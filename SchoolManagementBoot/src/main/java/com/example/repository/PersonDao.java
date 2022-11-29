package com.example.repository;

import java.util.List;

import com.example.models.Person;

public interface PersonDao {
	
	public void addPerson(Person p) throws Exception;
	public List<Person> getAllPeople();
	public Person getPersonByEmail(String email);
	public Person getPersonById(int id);
	public void deletePerson(String email);
	public void updatePerson(Person p);

}

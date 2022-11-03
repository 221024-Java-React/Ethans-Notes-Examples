package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.PersonDoesNotExistException;
import com.example.models.Person;

public class PersonDaoFile implements PersonDao {
	
	private FileIO<List<Person>> io;
	
	public PersonDaoFile() {
		this.io = new FileIO<List<Person>>("people.txt");
	}

	@Override
	public void addPerson(Person p) {
		
		List<Person> pList = io.readObject();
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		pList.add(p);
		
		io.writeObject(pList);
		
	}

	@Override
	public List<Person> getAllPeople() {
		List<Person> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		return pList;
	}

	@Override
	public Person getPersonByEmail(String email) {
		List<Person> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(Person p: pList) {
			if(p.getEmail().equals(email)) {
				return p;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new PersonDoesNotExistException();
	}

	@Override
	public void deletePerson(String email) {
		List<Person> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(int i=0; i<pList.size(); i++) {
			if(pList.get(i).getEmail().equals(email)) {
				pList.remove(i);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new PersonDoesNotExistException();
		
	}

	@Override
	public void updatePerson(Person p) {
		List<Person> pList = io.readObject();
		
		if(pList == null) {
			pList = new ArrayList<>();
		}
		
		for(int i=0; i<pList.size(); i++) {
			//We are assuming the email is the unique identifier
			if(pList.get(i).getEmail().equals(p.getEmail())) {
				pList.remove(i);
				pList.add(p);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new PersonDoesNotExistException();
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

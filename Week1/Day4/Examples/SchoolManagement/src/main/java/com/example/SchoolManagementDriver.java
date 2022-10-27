package com.example;

import com.example.dao.FileIO;
import com.example.dao.PersonDao;
import com.example.dao.PersonDaoFile;
import com.example.models.Person;
import com.example.services.PersonService;

public class SchoolManagementDriver {
	
	public static void main(String args[]) {
		/*
		Person p = new Person("Ethan", "McGill", 11122333l, true, "email@mail.com", "password", 3.0);

		FileIO<Person> personIO = new FileIO<Person>("person.txt");
		
		personIO.writeObject(p);
		
		System.out.println(personIO.readObject());
		*/
		//The easiest way to test before we have an api setup is through the driver
		PersonDao pDao = new PersonDaoFile();
		PersonService pService = new PersonService(pDao);
		
		pService.registerPerson("Andrew", "Hint", 111223333, false, "andrew@mail.com", "password", 4.0);
		
		System.out.println(pService.login("ethan@mail.com"));
		//pDao.addPerson(new Person("Ethan", "McGill", 111223333, true, "ethan@mail.com", "password", 0));
		
		System.out.println(pDao.getAllPeople());
		
		
	}
	
	
}

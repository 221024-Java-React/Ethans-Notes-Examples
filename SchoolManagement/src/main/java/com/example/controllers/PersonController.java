package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.models.Person;
import com.example.services.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class PersonController {
	
	private PersonService pServ;
	
	//Object mapper will be used to transform our java object from json and vise versa
	private ObjectMapper objectMapper;
	
	public PersonController(PersonService pServ) {
		this.pServ = pServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		
		//Inside is the logic for our controller for this register
		//When we register a person, we will send over information about that person in the body of the request
		//To get access to that body we use context.body()
		//To convert our body to a java object we will use the object mapper
		Person p = objectMapper.readValue(context.body(), Person.class);
		
		System.out.println(p);
		
		pServ.registerPerson(p);
		
		//Set our status code to OK
		context.status(201);
		context.result(objectMapper.writeValueAsString(p));
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Person> pList = pServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(pList));
	};
	
	public Handler handleLogin = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Person loggedIn = pServ.login(body.get("email"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(loggedIn));
		
	};
	
	public Handler handleDelete = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		pServ.removePerson(body.get("email"));
		
		context.status(200);
		context.result("Person was removed");
	};
	
	public Handler handleUpdate = (context) -> {
		Person p = objectMapper.readValue(context.body(), Person.class);
		
		pServ.updatePerson(p);
		
		context.status(200);
		context.result("Persons information was updated");
	};

}

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
		
		//Inside of the login, we probably want to store the users information inside of a cookie using
		// the session api
		
		//Get the current users session if it exists, or create a new session if none exist
		//context.req().getSession();
		
		//Create an attribute in the cookie called user and store the current users id
		context.req().getSession().setAttribute("user", loggedIn.getId());
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(loggedIn));
		
	};
	
	public Handler checkSession = (context) -> {
		
		//If there is no session with this attribute, no user is logged in
		if(context.sessionAttribute("user") == null) {
			//If you wanted to you could automatically invalidate the session created
			context.status(401);
			context.result("No user is logged in");
			return;
		}
		
		Integer id = (Integer) context.req().getSession().getAttribute("user");
		
		System.out.println(id);
		
		Person p = pServ.getPersonById(id);
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(p));
		
	};
	
	public Handler handleLogout = (context) -> {
		context.req().getSession().invalidate();
		
		//Probably want to actually pull in the logger
		context.status(200);
		context.result("User was logged out");
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

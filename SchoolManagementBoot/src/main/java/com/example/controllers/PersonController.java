package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.PersonAlreadyExistsException;
import com.example.models.Person;
import com.example.services.PersonService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/person")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PersonController {
	
	private PersonService personService;
	
	// /person/register
	//Request Mapping is mapping the router /person/register to this controller method
	//It is setting the request as a post
	@RequestMapping(path="/register", method=RequestMethod.POST)
	//ReponseBody is telling spring the response should be of type that is returned from this method
	@ResponseBody
	private String registerUser(@RequestBody /* We are expecting a Person object from the client */ Person p) {
		personService.registerPerson(p);
		return "Person was registered";
	}
	
	@ExceptionHandler({PersonAlreadyExistsException.class})
	@ResponseBody
	private ResponseEntity<String> handleUserExists() {
		return new ResponseEntity<String>("User already exists", HttpStatus.CONFLICT);
	}
	
	// /person/
	@GetMapping("/")
	@ResponseBody
	private List<Person> returnAllPeople(){
		return personService.getAllRegistered();
	}
	// /person/login
	@PostMapping("/login")
	@ResponseBody
	Person loginPerson(@RequestBody LinkedHashMap<String, String> body) {
		String email = body.get("email");
		String password = body.get("password");
		
		return personService.login(email, password);
	}
	
	@ExceptionHandler({InvalidCredentialsException.class})
	@ResponseBody
	private ResponseEntity<String> handleInvalidCredentials(){
		return new ResponseEntity<String>("Email or password incorrect", HttpStatus.UNAUTHORIZED);
	}
	
	// /person/{id} (delete)
	@DeleteMapping("/{id}")
	@ResponseBody
	private String deletePerson(@PathVariable("id")int id) {
		personService.removePerson(id);
		return "User removed";
	}
	
	// /person/ (put)
	@PutMapping("/")
	@ResponseBody
	private Person updatePerson(@RequestBody Person p) {
		personService.updatePerson(p);
		return personService.getPersonById(p.getId());
	}
}

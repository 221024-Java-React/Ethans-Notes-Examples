package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserService;
import com.example.validation.UserValidation;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class UserController {

	private UserService userService;
	
	//Setup the validator, we use @InitBinder, to bind our valdiator to our controller
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		if(User.class.isAssignableFrom(binder.getTarget().getClass())) {
			binder.addValidators(new UserValidation());
		}
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.readUsers();
	}
	
	@PostMapping("/")
	public User saveUser(@RequestBody @Validated User u, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("There was an error valdiating our user object");
			System.out.println(result.getAllErrors());
			return null;
		}
		
		return userService.createUser(u);
	}
	
	@PutMapping("/")
	public User updateUser(@RequestBody User u) {
		return userService.updateUser(u);
	}
	
	@DeleteMapping("/")
	public String deleteUser(@RequestBody User u) {
		userService.deleteUser(u);
		return "User was deleted";
	}
	
}

package com.example.service;

import java.util.ArrayList;

import com.example.models.Account;
import com.example.models.User;
import com.example.repository.UserRepository;

public class UserService {
	
	//Our useservice needs access to an instance of the user repository class, but we don't want to
	//instantiate a new repo for ever instance of the userservice
	//This is where spring and dependency injection comes in
	
	//Two types of dependency injection, Constructor and Setter
	//Constructor injection, means that spring will create the dependency instance, and provide that instance
	//through the constructor
	
	private UserRepository uRepo;
	
	public UserService(UserRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	public void saveUser(int id, String first, String last, String email, String password) {
		User u = new User(id, first, last, email, password, new ArrayList<Account>());
		System.out.println(u);
		uRepo.createUser(u);
	}
	
	
}

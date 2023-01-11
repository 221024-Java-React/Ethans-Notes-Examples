package com.example.repository;

import java.util.List;

import com.example.models.User;

public class UserRepositoryImpl implements UserRepository{

	@Override
	public List<User> readUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(User u) {
		System.out.println("New user created");
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

}

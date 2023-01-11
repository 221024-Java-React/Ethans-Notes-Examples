package com.example.repository;

import java.util.List;

import com.example.models.User;

public interface UserRepository {
	
	public List<User> readUsers();
	public void createUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);

}

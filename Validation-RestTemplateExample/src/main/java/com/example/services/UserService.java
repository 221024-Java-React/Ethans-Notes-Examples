package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class UserService {
	
	private UserRepository userRepo;
	
	//Quick crud
	public User createUser(User u) {
		return userRepo.save(u);
	}
	
	public List<User> readUsers(){
		return userRepo.findAll();
	}
	
	public User updateUser(User u) {
		//To update a record with Spring Data, we just use the save method
		return userRepo.save(u);
	}
	
	public void deleteUser(User u) {
		userRepo.delete(u);
	}

}

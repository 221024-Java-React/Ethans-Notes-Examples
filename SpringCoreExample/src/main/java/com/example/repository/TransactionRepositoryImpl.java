package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.models.Transaction;

//If we want spring to create an instance of this class automatically, we have to use a sterotype annotation
//Spring will see this annotation, and know that we want it to manage this class/this classes instance for us in
//the application context
//Stereotypes: Component, Service, Repository, Controller
@Repository
public class TransactionRepositoryImpl implements TransactionRepopository{

	@Override
	public void createTransaction(Transaction t) {
		System.out.println("Created a new Transaction");
	}

}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.models.Account;
import com.example.models.Transaction;
import com.example.models.TransactionType;
import com.example.repository.TransactionRepopository;

//Use the seterotype annotation to tell spring to manage an instance of our transaction service
@Component("TransactionServiceBean")
public class TransactionService {

	private TransactionRepopository tRepo;
	
	//Get an instance of our Transaction repo without setting the xml, or essentially automatically wire the bean by the type
	//-@Autowired will look for a bean of the specified type, and inject for automatically if it can be found
	@Autowired
	public TransactionService(TransactionRepopository tRepo) {
		this.tRepo = tRepo;
	}
	
	public void saveTransaction(TransactionType t, Account a, Account b, double amount) {
		Transaction transaction = new Transaction(1,t, a, b, amount);
		System.out.println(transaction);
		tRepo.createTransaction(transaction);
	}
	
}

package com.example.service;

import java.util.ArrayList;

import com.example.models.Account;
import com.example.models.AccountType;
import com.example.models.Transaction;
import com.example.models.User;
import com.example.repository.AccountRepository;

public class AccountService {
	
	private AccountRepository accountRepo;
	
	//Spring will call the no args, then call the constructor right after
	public AccountService() {
		System.out.println("Spring is calling me first");
	}
	
	public long saveAccount(long accountNum, User u, AccountType t) {
		Account a = new Account(accountNum, u, t, 0.0, new ArrayList<Transaction>());
		System.out.println(a);
		accountRepo.createAccount(a);
		return accountNum;
	}
	

	public void setAccountRepo(AccountRepository accountRepo) {
		System.out.println("Spring is calling me second");
		this.accountRepo = accountRepo;
	}
}

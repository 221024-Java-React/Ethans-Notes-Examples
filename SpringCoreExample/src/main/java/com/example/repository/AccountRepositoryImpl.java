package com.example.repository;

import java.util.List;

import com.example.models.Account;

public class AccountRepositoryImpl implements AccountRepository{

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createAccount(Account a) {
		System.out.println("Creating a new account");
		return 1l;
	}

	@Override
	public void updateAccount(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Account a) {
		// TODO Auto-generated method stub
		
	}

}

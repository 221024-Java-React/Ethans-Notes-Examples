package com.example.repository;

import java.util.List;

import com.example.models.Account;

public interface AccountRepository {
	
	public List<Account> getAccounts();
	//Return the new account number
	public long createAccount(Account a);
	public void updateAccount(Account a);
	public void deleteAccount(Account a);

}

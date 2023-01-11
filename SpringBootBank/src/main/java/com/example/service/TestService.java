package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Account;
import com.example.models.AccountType;
import com.example.models.User;
import com.example.repository.AccountRepository;
import com.example.repository.UserRepository;

@Service
@Transactional
public class TestService {
	
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private AccountRepository ar;
	
	public void setUpUserAndAccount() {
		User u = new User(1, "Ethan", "McGill", "ethan.mcgill@mail.com", "password", new ArrayList<Account>());
		User ethan = ur.save(u);
		Account a = new Account(1l, u, AccountType.CHECKING, 0.0);
		Account a1 = ar.save(a);
		List<Account> accounts = u.getAccounts();
		accounts.add(a1);
		ethan.setAccounts(accounts);
		System.out.println(ur.getById(1));
		System.out.println(ar.getById(1l));
	}

}

package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private long accountNumber;
	private User owner;
	private AccountType type;
	private double balance;
	//List of transactions
	private List<Transaction> transactions;
	
	public Account() {
		super();
		this.transactions = new ArrayList<>();
	}
	
	public Account(long accountNumber, User owner, AccountType type, double balance, List<Transaction> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.type = type;
		this.balance = balance;
		this.transactions = transactions;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", owner=" + owner + ", type=" + type + ", balance="
				+ balance + ", transactions=" + transactions + "]";
	}
	
	

}

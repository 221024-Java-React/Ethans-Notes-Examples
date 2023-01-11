package com.example.models;

public class Transaction {
	
	private int transactionId;
	private TransactionType type;
	private Account to;
	private Account from;
	private double amount;
		
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, TransactionType type, Account to, Account from, double amount) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.to = to;
		this.from = from;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", type=" + type + ", to=" + to + ", from=" + from
				+ ", amount=" + amount + "]";
	}
	
}

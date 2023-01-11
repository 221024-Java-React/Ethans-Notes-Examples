package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.AccountTransaction;

public interface TransactionRepository extends JpaRepository<AccountTransaction, Integer>{

}

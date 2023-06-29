package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findBySendTransactionId(int accountNumber);
}

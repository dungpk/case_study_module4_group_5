package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}

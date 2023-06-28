package com.codegym.haichanbank.service.TransactionService;

import com.codegym.haichanbank.model.Transaction;
import com.codegym.haichanbank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);
    }
}

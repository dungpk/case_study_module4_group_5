package com.codegym.haichanbank.service.AccountService;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountsRepository accountsRepository;
    @Override
    public Iterable<Accounts> findAll() {
        return accountsRepository.findAll();
    }

    @Override
    public Optional<Accounts> findById(Long id) {
        return accountsRepository.findById(id);
    }

    @Override
    public Accounts save(Accounts accounts) {

        return accountsRepository.save(accounts);
    }

    @Override
    public void remove(Long id) {
        accountsRepository.deleteById(id);
    }
}

package com.codegym.haichanbank.service.SavingAccountService;

import com.codegym.haichanbank.model.SavingAccount;
import com.codegym.haichanbank.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SavingAccountService implements ISavingAccountService {

    @Autowired
    SavingAccountRepository savingAccountRepository;

    @Override
    public Iterable<SavingAccount> findAll() {
        return savingAccountRepository.findAll();
    }

    @Override
    public Optional<SavingAccount> findById(Long id) {
        return savingAccountRepository.findById(id);
    }

    @Override
    public void save(SavingAccount savingAccount) {
        savingAccountRepository.save(savingAccount);
    }

    @Override
    public void remove(Long id) {
        savingAccountRepository.deleteById(id);
    }
}

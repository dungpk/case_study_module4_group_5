package com.codegym.haichanbank.service.AccountService;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.AccountsRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;
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

    @Override
    public Accounts findByCustomerId(int customerId) {
        return accountsRepository.findByCustomerId(customerId);
    }

    @Override
    public Accounts getAccountDetails(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            Accounts accounts = accountsRepository.findByCustomerId(customers.get(0).getId());
            if (accounts != null) {
                return accounts;
            }
        }
        return null;
    }
}

package com.codegym.haichanbank.service.CustomerService;

import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.ContactRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {

        return customerRepository.findById(id);
    }

    @Override
    public void satve(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}

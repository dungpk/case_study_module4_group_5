package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmail(String email);

    Optional<Customer> findCustomerByEmail(String email);

}

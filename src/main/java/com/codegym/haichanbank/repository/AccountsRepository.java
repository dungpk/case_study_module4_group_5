package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(int customerId);
}

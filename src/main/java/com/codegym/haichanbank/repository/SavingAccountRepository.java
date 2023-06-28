package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long> {

}

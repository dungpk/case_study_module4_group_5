package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long> {
    List<SavingAccount> findByCardId(int cardId);
}

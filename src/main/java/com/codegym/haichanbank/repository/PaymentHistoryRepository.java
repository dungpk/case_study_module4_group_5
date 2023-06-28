package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory,Long> {
    List<PaymentHistory> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}

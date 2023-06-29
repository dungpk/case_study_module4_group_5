package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory,String> {
    List<PaymentHistory> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}

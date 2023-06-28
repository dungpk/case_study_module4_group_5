package com.codegym.haichanbank.service.PaymentService;

import com.codegym.haichanbank.model.PaymentHistory;
import com.codegym.haichanbank.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentHistoryService implements IPaymentHistoryService {
    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;
    @Override
    public Iterable<PaymentHistory> findAll() {
        return paymentHistoryRepository.findAll();
    }

    @Override
    public Optional<PaymentHistory> findById(Long id) {
        return paymentHistoryRepository.findById(id);
    }

    @Override
    public PaymentHistory save(PaymentHistory paymentHistory) {
        return paymentHistoryRepository.save(paymentHistory);
    }

    @Override
    public void remove(Long id) {
        paymentHistoryRepository.deleteById(id);
    }
}

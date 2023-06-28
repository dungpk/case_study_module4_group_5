package com.codegym.haichanbank.service.PaymentService;

import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.model.PaymentHistory;
import com.codegym.haichanbank.repository.CustomerRepository;
import com.codegym.haichanbank.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentHistoryService implements IPaymentHistoryService {

    @Autowired
    private CustomerRepository customerRepository;

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
    public void save(PaymentHistory paymentHistory) {
        paymentHistoryRepository.save(paymentHistory);
    }

    @Override
    public void remove(Long id) {
        paymentHistoryRepository.deleteById(id);
    }

    @Override
    public List<PaymentHistory> getBalanceDetails(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<PaymentHistory> accountTransactions = paymentHistoryRepository.
                    findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
            if (accountTransactions != null ) {
                return accountTransactions;
            }
        }
        return null;
    }
}

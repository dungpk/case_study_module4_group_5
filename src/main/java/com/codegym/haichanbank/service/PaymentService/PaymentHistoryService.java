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
public class PaymentHistoryService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;
//    @Override
    public Iterable<PaymentHistory> findAll() {
        return paymentHistoryRepository.findAll();
    }

//    @Override
    public Optional<PaymentHistory> findById(String id) {
        return paymentHistoryRepository.findById(id);
    }

//    @Override
    public PaymentHistory save(PaymentHistory paymentHistory) {
        return paymentHistoryRepository.save(paymentHistory);
    }

    public List<PaymentHistory> findAllByCustomerID(int customer_id){
        return paymentHistoryRepository.findByCustomerIdOrderByTransactionDtDesc(customer_id);
    }
//    @Override
    public void remove(String id) {
        paymentHistoryRepository.deleteById(id);
    }

//    @Override
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

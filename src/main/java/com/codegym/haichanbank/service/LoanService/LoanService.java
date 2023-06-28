package com.codegym.haichanbank.service.LoanService;

import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.model.Loans;
import com.codegym.haichanbank.repository.CustomerRepository;
import com.codegym.haichanbank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService implements ILoanService{

    @Autowired
    private LoanRepository loanRepository;


    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable<Loans> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Optional<Loans> findById(Long id) {
        return loanRepository.findById(id);
    }

    @Override
    public Loans save(Loans loans) {

        return loanRepository.save(loans);
    }

    @Override
    public void remove(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public List<Loans> getLoanDetails(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
            if (loans != null ) {
                return loans;
            }
        }
        return null;
    }
}

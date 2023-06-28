package com.codegym.haichanbank.service.LoanService;

import com.codegym.haichanbank.model.Loans;
import com.codegym.haichanbank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService implements ILoanService{

    @Autowired
    private LoanRepository loanRepository;
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
}

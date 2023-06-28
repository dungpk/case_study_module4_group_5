package com.codegym.haichanbank.service.LoanService;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Loans;
import com.codegym.haichanbank.service.IGeneralService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ILoanService  extends IGeneralService<Loans> {
    public List<Loans> getLoanDetails(String email);
}

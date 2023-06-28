package com.codegym.haichanbank.service.AccountService;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.service.IGeneralService;

public interface IAccountService extends IGeneralService<Accounts> {
    Accounts findByCustomerId(int customerId);
}

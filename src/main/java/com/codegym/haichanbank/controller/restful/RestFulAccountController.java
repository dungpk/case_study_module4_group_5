package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.AccountsRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
import com.codegym.haichanbank.service.AccountService.AccountService;
import com.codegym.haichanbank.service.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestFulAccountController {
    @Autowired
    private AccountService accountsService;

    @Autowired
    private CustomerService customerService;

}

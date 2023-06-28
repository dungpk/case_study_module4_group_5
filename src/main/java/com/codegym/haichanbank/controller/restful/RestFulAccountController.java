package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.AccountsRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
import com.codegym.haichanbank.service.AccountService.AccountService;
import com.codegym.haichanbank.service.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class RestFulAccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        Accounts accounts = accountService.getAccountDetails("happy@example.com");
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}

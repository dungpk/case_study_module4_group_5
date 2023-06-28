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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class RestFulAccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    public ResponseEntity<Accounts> getAccountDetails() {
        Accounts accounts = accountService.findByCustomerId(1);
        if (accounts != null ) {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/userPortal")
    public ResponseEntity<Customer> getCustomer(){
        Optional<Customer> customer = customerService.findById(1L);
        if(customer.isPresent()){
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RestFulLoginController {


    @Autowired
    private CustomerRepository customerRepository;


}

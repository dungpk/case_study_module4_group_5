package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RestFulLoginController {

    @Autowired
    private CustomerRepository customerRepository;


}

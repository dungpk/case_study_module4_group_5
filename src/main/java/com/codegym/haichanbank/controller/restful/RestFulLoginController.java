package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@RestController
public class RestFulLoginController {


    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("login")
    public ResponseEntity<String> confirmLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(username);
        if(customerOptional.isPresent()){
            Customer exist = customerOptional.get();
            if (exist.getPwd().equals(password)) {
                return ResponseEntity.ok("vcl");
            }else {
                return new ResponseEntity<>("ngu", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>("dmm", HttpStatus.OK);
    }

}

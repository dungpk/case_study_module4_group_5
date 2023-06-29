package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.service.CardService.CardService;
import com.codegym.haichanbank.service.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("card")
public class RestFulCardsController {
    @Autowired
    private CardService cardService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/myCard")
    public ResponseEntity<Iterable<Cards>> getCardDetails(@RequestParam String email
    ){
       List<Cards> cards = cardService.getCardDetails(email);
        if(cards.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(cards,HttpStatus.OK);
        }

    }

    @GetMapping("/getCustomer")
    public ResponseEntity<String> getCustomerByCardNumber(@RequestParam String cardNumber
    ){
        String nameCustomer;
        Customer customer = customerService.findCustomerByCardNumber(cardNumber);

        if(customer == null){
            nameCustomer = "Customer Not Found";
        }else{
            nameCustomer = customer.getName();
        }

        return new ResponseEntity<>(nameCustomer,HttpStatus.OK);
    }
}

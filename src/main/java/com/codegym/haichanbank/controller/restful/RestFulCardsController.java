package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.CardsRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
import com.codegym.haichanbank.service.CardService.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@CrossOrigin
@Controller
public class RestFulCardsController {
    @Autowired
    private CardService cardService;
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
}

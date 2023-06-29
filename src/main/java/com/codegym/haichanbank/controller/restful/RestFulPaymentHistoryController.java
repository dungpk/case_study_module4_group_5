package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.PaymentHistory;
import com.codegym.haichanbank.service.CardService.CardService;
import com.codegym.haichanbank.service.PaymentService.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
public class RestFulPaymentHistoryController {
    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @Autowired
    private CardService cardService;


    @GetMapping("/paidHistory")
    public ResponseEntity<List<PaymentHistory>> findAllHistory(){
        return ResponseEntity.ok(paymentHistoryService.findAllByCustomerID(1));
    }
    @PostMapping("/payment/{type}/{amt}")
    public ResponseEntity<PaymentHistory> paid(@PathVariable String type, @PathVariable int amt, @RequestBody int card_id){
        Cards user_card = cardService.findById(card_id).get();
        user_card.setAmountUsed(user_card.getAmountUsed() + amt);
        user_card.setAvailableAmount(user_card.getAvailableAmount() - amt);
        cardService.save(user_card);
        Random rd = new Random();
        PaymentHistory paid = new PaymentHistory("af0-3299-4910-be" + rd.nextInt(10000),1865764534, 1, Date.valueOf(LocalDate.now()), type, "withdraw", amt, 30000, LocalDate.now() + "");
        paymentHistoryService.save(paid);
        return new ResponseEntity<>(paid, HttpStatus.OK);
    }
}

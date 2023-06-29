package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Transaction;
import com.codegym.haichanbank.service.TransactionService.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/transaction")
public class RestFulTransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping
    public ResponseEntity<Transaction>transactionProcessing( @RequestBody List<Object> inputInformationObject) {

        LinkedHashMap cardNumberSendLink = (LinkedHashMap) inputInformationObject.get(0);
        String cardNumberSend = (String) cardNumberSendLink.values().stream().findFirst().get();

        LinkedHashMap cardNumberReceiveLink = (LinkedHashMap) inputInformationObject.get(1);
        String cardNumberReceive = (String) cardNumberReceiveLink.values().stream().findFirst().get();

        LinkedHashMap nameCustomerSendLink = (LinkedHashMap) inputInformationObject.get(2);
        String nameCustomerSend = (String) nameCustomerSendLink.values().stream().findFirst().get();

        LinkedHashMap nameCustomerReceiveLink = (LinkedHashMap) inputInformationObject.get(3);
        String nameCustomerReceive = (String) nameCustomerReceiveLink.values().stream().findFirst().get();

        LinkedHashMap amountOfMoneyLink = (LinkedHashMap) inputInformationObject.get(4);
        int amountOfMoney = (int) amountOfMoneyLink.values().stream().findFirst().get();


        Transaction transaction= transactionService.transactionHandler(cardNumberSend,cardNumberReceive,nameCustomerSend,
                nameCustomerReceive,amountOfMoney);
        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }

}

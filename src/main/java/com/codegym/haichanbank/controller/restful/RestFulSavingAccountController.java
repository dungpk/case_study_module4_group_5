package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.SavingAccount;
import com.codegym.haichanbank.service.SavingAccountService.ISavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class RestFulSavingAccountController {
    @Autowired
    private ISavingAccountService savingAccountService;
    @GetMapping("/savingAccount/{card_id}")
    public ResponseEntity<SavingAccount> getSavingAccount(@PathVariable Long card_id){
        Optional<SavingAccount> optionalSavingAccount = savingAccountService.findById(card_id);
        if (optionalSavingAccount.isPresent()){
            return new ResponseEntity<>(optionalSavingAccount.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

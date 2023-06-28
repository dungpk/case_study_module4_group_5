package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.SavingAccount;
import com.codegym.haichanbank.service.SavingAccountService.ISavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class RestFulSavingAccountController {
    @Autowired
    private ISavingAccountService savingAccountService;
    @GetMapping("/savingAccount")
    public ResponseEntity<SavingAccount> getSavingAccount(){
        Optional<SavingAccount> optionalSavingAccount = savingAccountService.findById(1L);
        if (optionalSavingAccount.isPresent()){
            return new ResponseEntity<>(optionalSavingAccount.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

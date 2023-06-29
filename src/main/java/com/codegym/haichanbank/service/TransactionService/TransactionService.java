package com.codegym.haichanbank.service.TransactionService;

import com.codegym.haichanbank.model.Accounts;
import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.model.Transaction;
import com.codegym.haichanbank.repository.CardsRepository;
import com.codegym.haichanbank.repository.TransactionRepository;
import com.codegym.haichanbank.service.AccountService.AccountService;
import com.codegym.haichanbank.service.CardService.CardService;
import com.codegym.haichanbank.service.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    AccountService accountService;


    @Autowired
    CardsRepository cardsRepository;

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) {

            return transactionRepository.save(transaction);
    }

    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction transactionHandler(String cardNumberSend, String cardNumberReceive, String nameCustomerSend, String nameCustomerReceive,int amountOfMoney) {

        Transaction transaction = new Transaction();
        transaction.setDate(new Date());

         Customer customerSendVerify = customerService.findCustomerByCardNumber(cardNumberSend);
         Customer customerReceiveVerify = customerService.findCustomerByCardNumber(cardNumberReceive);

        if(customerSendVerify == null){
            transaction.setSendTransactionId(0);
            transaction.setAmount(0);
            transaction.setActive(false);
        }else{

            Accounts accountSend = accountService.findByCustomerId(customerSendVerify.getId());
            transaction.setSendTransactionId(accountSend.getAccountNumber());
        }

        if(customerReceiveVerify == null){
            transaction.setReceiveTransactionId(0);
        }else{

            Accounts accountReceive = accountService.findByCustomerId(customerReceiveVerify.getId());
            transaction.setReceiveTransactionId(accountReceive.getAccountNumber());
        }

        int moneyVariable;

        List<Cards> cardSends = cardsRepository.findByCardNumber(cardNumberSend);
        List<Cards> cardReceives = cardsRepository.findByCardNumber(cardNumberReceive);

        if(cardSends.isEmpty()){
            moneyVariable = 0;
        }else {
            moneyVariable = cardSends.get(0).getAvailableAmount();

            if(moneyVariable<amountOfMoney){
                transaction.setAmount(0);

            }else{
                transaction.setAmount(amountOfMoney);
            }
        }

        if(transaction.getSendTransactionId()==0||transaction.getReceiveTransactionId()==0||transaction.getAmount()==0){
            transaction.setActive(false);
            return transaction;
        }else{


            Cards cardSend;
            Cards cardReceive;
            if(!cardSends.isEmpty()  && !cardReceives.isEmpty()){
                cardSend = cardSends.get(0);
                cardSend.setAvailableAmount(cardSend.getAvailableAmount()-amountOfMoney);
                cardSend.setAmountUsed(cardSend.getAmountUsed()+amountOfMoney);
                cardsRepository.save(cardSend);

                cardReceive = cardReceives.get(0);
                cardReceive.setAvailableAmount(cardReceive.getAvailableAmount()+amountOfMoney);
                cardReceive.setTotalLimit(cardReceive.getTotalLimit()+amountOfMoney);
                cardsRepository.save(cardReceive);

                transaction.setActive(true);
                transactionRepository.save(transaction);
            }else{
                transaction.setActive(false);
                return transaction;
            }



            return transaction;

        }

    }
}

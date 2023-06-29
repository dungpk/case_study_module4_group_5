package com.codegym.haichanbank.service.TransactionService;

import com.codegym.haichanbank.model.Notice;
import com.codegym.haichanbank.model.Transaction;
import com.codegym.haichanbank.service.IGeneralService;

public interface ITransactionService extends IGeneralService<Transaction> {
    Transaction transactionHandler(String cardNumberSend, String cardNumberReceive, String nameCustomerSend, String nameCustomerReceive,int amountOfString);
}

package com.codegym.haichanbank.model;

import java.util.ArrayList;
import java.util.List;

public class ListNoticeCustomer {
    private List<SavingAccount> savingAccountsUnread ;
    private List<Transaction> transactionsUnread ;
    private List<SavingAccount> savingAccountsRead ;
    private List<Transaction> transactionsRead;

    public List<SavingAccount> getSavingAccountsUnread() {
        return savingAccountsUnread;
    }

    public void setSavingAccountsUnread(List<SavingAccount> savingAccountsUnread) {
        this.savingAccountsUnread = savingAccountsUnread;
    }

    public List<Transaction> getTransactionsUnread() {
        return transactionsUnread;
    }

    public void setTransactionsUnread(List<Transaction> transactionsUnread) {
        this.transactionsUnread = transactionsUnread;
    }

    public List<SavingAccount> getSavingAccountsRead() {
        return savingAccountsRead;
    }

    public void setSavingAccountsRead(List<SavingAccount> savingAccountsRead) {
        this.savingAccountsRead = savingAccountsRead;
    }

    public List<Transaction> getTransactionsRead() {
        return transactionsRead;
    }

    public void setTransactionsRead(List<Transaction> transactionsRead) {
        this.transactionsRead = transactionsRead;
    }

    public ListNoticeCustomer(List<SavingAccount> savingAccountsUnread, List<Transaction> transactionsUnread, List<SavingAccount> savingAccountsRead, List<Transaction> transactionsRead) {
        this.savingAccountsUnread = savingAccountsUnread;
        this.transactionsUnread = transactionsUnread;
        this.savingAccountsRead = savingAccountsRead;
        this.transactionsRead = transactionsRead;
    }

    public ListNoticeCustomer() {
    }
}

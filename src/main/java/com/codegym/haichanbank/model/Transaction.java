package com.codegym.haichanbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "send_transaction_id")
    private int sendTransactionId;

    @Column(name = "receive_transaction_id")
    private int receiveTransactionId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "transaction_is_active")
    private boolean isActive;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getSendTransactionId() {
        return sendTransactionId;
    }

    public void setSendTransactionId(int sendTransactionId) {
        this.sendTransactionId = sendTransactionId;
    }

    public int getReceiveTransactionId() {
        return receiveTransactionId;
    }

    public void setReceiveTransactionId(int receiveTransactionId) {
        this.receiveTransactionId = receiveTransactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Transaction(int transactionId, int sendTransactionId, int receiveTransactionId, int amount, Date date, boolean isActive) {
        this.transactionId = transactionId;
        this.sendTransactionId = sendTransactionId;
        this.receiveTransactionId = receiveTransactionId;
        this.amount = amount;
        this.date = date;
        this.isActive = isActive;
    }

    public Transaction() {
    }
}

package com.codegym.haichanbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "saving_account" )
public class SavingAccount {

    @Id
    @Column(name = "saving_account_id")
    private int savingAccountId;

    @Column(name="card_id")
    private int cardId;


    @Column(name = "init_amount")
    private int initAmount;

    @Column(name = "duration")
    private int duration;

    @Column(name = "interest")
    private float interest;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "expired_dt")
    private Date expiredDt;

    @Column(name = "saving_account_is_active")
    private boolean isActive;

    public SavingAccount() {
    }

    public SavingAccount(int savingAccountId, int cardId, int initAmount, int duration, float interest, Date createDt, Date expiredDt, boolean isActive) {
        this.savingAccountId = savingAccountId;
        this.cardId = cardId;
        this.initAmount = initAmount;
        this.duration = duration;
        this.interest = interest;
        this.createDt = createDt;
        this.expiredDt = expiredDt;
        this.isActive = isActive;
    }

    public int getSavingAccountId() {
        return savingAccountId;
    }

    public void setSavingAccountId(int savingAccountId) {
        this.savingAccountId = savingAccountId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(int initAmount) {
        this.initAmount = initAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getExpiredDt() {
        return expiredDt;
    }

    public void setExpiredDt(Date expiredDt) {
        this.expiredDt = expiredDt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

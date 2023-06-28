package com.codegym.haichanbank.service.PaymentService;

import com.codegym.haichanbank.model.PaymentHistory;
import com.codegym.haichanbank.service.IGeneralService;

import java.util.List;

public interface IPaymentHistoryService extends IGeneralService<PaymentHistory> {

    List<PaymentHistory> getBalanceDetails(String email);
}

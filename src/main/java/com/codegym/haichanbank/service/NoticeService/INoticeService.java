package com.codegym.haichanbank.service.NoticeService;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.ListNoticeCustomer;
import com.codegym.haichanbank.model.Notice;
import com.codegym.haichanbank.service.IGeneralService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INoticeService extends IGeneralService<Notice> {
    public ResponseEntity<List<Notice>> getNotices();
    ListNoticeCustomer getAccountNotices(String email);
}

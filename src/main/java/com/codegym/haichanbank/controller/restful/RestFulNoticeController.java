package com.codegym.haichanbank.controller.restful;

import com.codegym.haichanbank.model.ListNoticeCustomer;
import com.codegym.haichanbank.model.Notice;
import com.codegym.haichanbank.repository.NoticeRepository;
import com.codegym.haichanbank.service.NoticeService.NoticeService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin("*")
@Controller
@RequestMapping("/notice")
public class RestFulNoticeController {


    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private NoticeService noticeService;


    @GetMapping("/myNotice/{emailCustomer}")
    public ResponseEntity<ListNoticeCustomer> getAccountNotices(@PathVariable String emailCustomer){
        ListNoticeCustomer listNoticeCustomer = noticeService.getAccountNotices(emailCustomer);

        if(listNoticeCustomer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listNoticeCustomer,HttpStatus.OK);
        }
    }


    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null ) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }else {
            return null;
        }
    }

}

package com.codegym.haichanbank.service.NoticeService;

import com.codegym.haichanbank.model.Loans;
import com.codegym.haichanbank.model.Notice;
import com.codegym.haichanbank.repository.NoticeRepository;
import com.codegym.haichanbank.service.LoanService.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class NoticeService implements INoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @Override
    public Iterable<Notice> findAll() {
        return noticeRepository.findAll();
    }

    @Override
    public Optional<Notice> findById(Long id) {
        return noticeRepository.findById(id);
    }

    @Override
    public void save(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public void remove(Long id) {
        noticeRepository.deleteById(id);
    }

    @Override
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

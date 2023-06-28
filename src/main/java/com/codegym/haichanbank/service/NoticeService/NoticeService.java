package com.codegym.haichanbank.service.NoticeService;

import com.codegym.haichanbank.model.Loans;
import com.codegym.haichanbank.model.Notice;
import com.codegym.haichanbank.repository.NoticeRepository;
import com.codegym.haichanbank.service.LoanService.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        noticeRepository.save(notice)
    }

    @Override
    public void remove(Long id) {
        noticeRepository.deleteById(id);
    }
}

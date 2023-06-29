package com.codegym.haichanbank.service.NoticeService;

import com.codegym.haichanbank.model.*;
import com.codegym.haichanbank.repository.*;
import com.codegym.haichanbank.service.AccountService.AccountService;
import com.codegym.haichanbank.service.CardService.CardService;
import com.codegym.haichanbank.service.CardService.ICardService;
import com.codegym.haichanbank.service.LoanService.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class NoticeService implements INoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SavingAccountRepository savingAccountRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Iterable<Notice> findAll() {
        return noticeRepository.findAll();
    }

    @Override
    public Optional<Notice> findById(Long id) {
        return noticeRepository.findById(id);
    }

    @Override

    public Notice save(Notice notice) {

        return noticeRepository.save(notice);
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


    @Override
    public ListNoticeCustomer getAccountNotices(String email) {

        List<SavingAccount> savingAccountsUnread = new ArrayList<>();
        List<Transaction> transactionsUnread = new ArrayList<>();
        List<SavingAccount> savingAccountsRead = new ArrayList<>();
        List<Transaction> transactionsRead = new ArrayList<>();

        List<Customer> customers = customerRepository.findByEmail(email);

        System.out.println("afsd");

        if(!customers.isEmpty()){
            List<Cards> cards = cardsRepository.findByCustomerId(customers.get(0).getId());
            if(!cards.isEmpty()){
                for (Cards element : cards) {
                    List<SavingAccount> savingAccountList = savingAccountRepository.findByCardId(element.getCardId());
                    if(!savingAccountList.isEmpty()){
                        for (SavingAccount savingAccount : savingAccountList) {
                            if(savingAccount.isActive()){
                                savingAccountsUnread.add(savingAccount);
                                savingAccount.setActive(false);
                                savingAccountRepository.save(savingAccount);
                            }else{
                                savingAccountsRead.add(savingAccount);
                            }

                        }
                    }
                }
            }
        }

        Accounts accounts = accountService.getAccountDetails(email);

        if(accounts!=null)
        {
            List<Transaction> transactionList = transactionRepository.findBySendTransactionId(accounts.getAccountNumber());
            if(!transactionList.isEmpty()){
                for (Transaction transaction : transactionList){
                    if(transaction.isActive()){
                        transactionsUnread.add(transaction);
                        transaction.setActive(false);
                        transactionRepository.save(transaction);
                    }else{
                        transactionsRead.add(transaction);
                    }
                }
            }
        }


        ListNoticeCustomer listNoticeCustomer =  new ListNoticeCustomer();
        listNoticeCustomer.setSavingAccountsRead(savingAccountsRead);
        listNoticeCustomer.setSavingAccountsUnread(savingAccountsUnread);
        listNoticeCustomer.setTransactionsRead(transactionsRead);
        listNoticeCustomer.setTransactionsUnread(transactionsUnread);

        return listNoticeCustomer;
    }
}

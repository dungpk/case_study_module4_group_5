package com.codegym.haichanbank.service.ContactService;

import com.codegym.haichanbank.model.Contact;
import com.codegym.haichanbank.repository.AccountsRepository;
import com.codegym.haichanbank.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService implements IContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void remove(Long id) {
        contactRepository.deleteById(id);
    }
}

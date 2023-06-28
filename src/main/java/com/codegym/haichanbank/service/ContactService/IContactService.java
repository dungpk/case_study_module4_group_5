package com.codegym.haichanbank.service.ContactService;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Contact;
import com.codegym.haichanbank.service.IGeneralService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IContactService extends IGeneralService<Contact> {

    public List<Contact> saveContactInquiryDetails(List<Contact> contacts);
}

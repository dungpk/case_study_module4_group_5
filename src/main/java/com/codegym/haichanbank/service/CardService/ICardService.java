package com.codegym.haichanbank.service.CardService;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.service.IGeneralService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICardService extends IGeneralService<Cards> {
     List<Cards> getCardDetails(String email);
}

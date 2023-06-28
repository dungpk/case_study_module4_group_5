package com.codegym.haichanbank.service.CardService;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService implements ICardService{

    @Autowired
    CardsRepository cardsRepository;
    @Override
    public Iterable<Cards> findAll() {
        return cardsRepository.findAll();
    }

    @Override
    public Optional<Cards> findById(Long id) {
        return cardsRepository.findById(id);
    }

    @Override
    public Cards save(Cards cards) {
        return cardsRepository.save(cards);
    }


    @Override
    public void remove(Long id) {

    }
}

package com.codegym.haichanbank.service.CardService;

import com.codegym.haichanbank.model.Cards;

import java.util.Optional;

public class CardService implements ICardService{


    @Override
    public Iterable<Cards> findAll() {
        return null;
    }

    @Override
    public Optional<Cards> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Cards cards) {

    }

    @Override
    public void remove(Long id) {

    }
}

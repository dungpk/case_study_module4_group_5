package com.codegym.haichanbank.service.CardService;

import com.codegym.haichanbank.model.Cards;
<<<<<<< HEAD
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.CardsRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
=======
import com.codegym.haichanbank.repository.CardsRepository;
>>>>>>> dung
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService{
    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
<<<<<<< HEAD
    private CustomerRepository customerRepository;
    private String email;

=======
    CardsRepository cardsRepository;
>>>>>>> dung
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

    @Override
    public List<Cards> getCardDetails(String email) {

        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Cards> cards = cardsRepository.findByCustomerId(customers.get(0).getId());
            if (cards != null ) {
                return cards;
            }
        }
        return null;
    }
}

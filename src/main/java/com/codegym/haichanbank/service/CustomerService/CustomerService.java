package com.codegym.haichanbank.service.CustomerService;

import com.codegym.haichanbank.model.Cards;
import com.codegym.haichanbank.model.Customer;
import com.codegym.haichanbank.repository.CardsRepository;
import com.codegym.haichanbank.repository.ContactRepository;
import com.codegym.haichanbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.OptionalValueBinding;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {

        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return  customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findCustomerByCardNumber(String cardNumber) {

        List<Cards> cards = cardsRepository.findByCardNumber(cardNumber);

        if (cards != null && !cards.isEmpty()) {
            Optional<Customer> customer = customerRepository.findById(Long.valueOf(cards.get(0).getCustomerId()));
            if (customer.isPresent()) {
                return customer.get();
            }
        }
        return null;
    }

}

package com.codegym.haichanbank.repository;

import com.codegym.haichanbank.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
	List<Cards> findByCustomerId(int customerNumber);
	List<Cards>  findByCardNumber(String customerNumber);


}

package com.se.onlinemoviebooking.application.database.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.se.onlinemoviebooking.application.dao.PaymentcardDAO;

public interface PaymentCardRepository  extends JpaRepository<PaymentcardDAO,Long>{
	
	@Query("SELECT p FROM PaymentcardDAO p WHERE p.userID = ?1")
	Collection<PaymentcardDAO> getAllUserCards(Integer userID);
	
	@Transactional
	@Modifying
	@Query("update PaymentcardDAO p set p.cardNumber = ?1, p.cardExpiry = ?2, p.billingAddress = ?3 WHERE p.cardID = ?4")
	public int updateCard(String cardNumber, String cardExpiry, String billingAddress, Integer cardID);
	
	
	@Transactional
	@Modifying
	@Query("delete from PaymentcardDAO p where p.cardID = ?1")
	public int deleteBycardID(Integer cardID);

}

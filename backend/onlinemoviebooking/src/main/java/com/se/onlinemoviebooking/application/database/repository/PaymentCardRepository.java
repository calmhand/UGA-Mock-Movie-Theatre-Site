package com.se.onlinemoviebooking.application.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.onlinemoviebooking.application.dao.PaymentcardDAO;

public interface PaymentCardRepository  extends JpaRepository<PaymentcardDAO,Long>{

}

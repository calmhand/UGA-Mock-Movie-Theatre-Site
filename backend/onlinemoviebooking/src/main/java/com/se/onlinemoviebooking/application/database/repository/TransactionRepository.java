package com.se.onlinemoviebooking.application.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.onlinemoviebooking.application.dao.TransactionDAO;

public interface TransactionRepository extends JpaRepository<TransactionDAO, Long>{
	
	
	@Query("select t from TransactionDAO t WHERE t.transactionID = ?1")
	public TransactionDAO getTransactionByID (Long transactionID);

}

package com.se.onlinemoviebooking.application.database.service;

import com.se.onlinemoviebooking.application.dto.TransactionDTO;

public interface TransactionService {

	public TransactionDTO saveTransaction(TransactionDTO transactionDTO);

	public TransactionDTO getTransactionById(Long transactionID);

}

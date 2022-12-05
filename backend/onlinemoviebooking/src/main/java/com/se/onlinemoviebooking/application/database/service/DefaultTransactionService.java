package com.se.onlinemoviebooking.application.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onlinemoviebooking.application.dao.TransactionDAO;
import com.se.onlinemoviebooking.application.database.repository.TransactionRepository;
import com.se.onlinemoviebooking.application.dto.AddressDTO;
import com.se.onlinemoviebooking.application.dto.TransactionDTO;
import com.se.onlinemoviebooking.application.dto.TransactionDetails;
import com.se.onlinemoviebooking.application.dto.TransactionType;

@Service("transactionService")
public class DefaultTransactionService implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
		TransactionDAO row = populateTransactionEntity(transactionDTO);
		return populateTransactionData(transactionRepository.save(row));
	}

	@Override
	public TransactionDTO getTransactionById(Long transactionID) {
		TransactionDAO transaction = transactionRepository.getTransactionByID(transactionID);
		return populateTransactionData(transaction);
	}

	public static TransactionDAO populateTransactionEntity(TransactionDTO transaction) {

		TransactionDAO transactionDAO = new TransactionDAO();
		
		transactionDAO.setTransactionTime(transaction.getTransactionTime());
		transactionDAO.setTransactionType(transaction.getTransactionType().getName());
		transactionDAO.setTransactionDetails(transaction.getTransactionDetails().toJSONString());
		transactionDAO.setTransactionAmount(transaction.getTrasactionAmount());
		transactionDAO.setBillingAddress(transaction.getBillingAddress().toJSONString());
		
		
		return transactionDAO;

	}

	public static TransactionDTO populateTransactionData(TransactionDAO transaction) {

		TransactionDTO transactionDTO = new TransactionDTO();
		
		transactionDTO.setTransactionID(transaction.getTransactionID());
		transactionDTO.setTransactionTime(transaction.getTransactionTime());
		transactionDTO.setTransactionType(TransactionType.getStatusByName(transaction.getTransactionType()));
		transactionDTO.setTransactionDetails(TransactionDetails.getObject(transaction.getTransactionDetails()));
		transactionDTO.setTrasactionAmount(transaction.getTransactionAmount());
		transactionDTO.setBillingAddress(AddressDTO.getObject(transaction.getBillingAddress()));
		
		return transactionDTO;

	}

}

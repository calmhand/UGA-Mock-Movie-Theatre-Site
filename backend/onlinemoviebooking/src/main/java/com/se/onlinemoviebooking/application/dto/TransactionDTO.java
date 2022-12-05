package com.se.onlinemoviebooking.application.dto;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TransactionDTO implements SimpleDTO{
	private Long transactionID;
	private LocalDateTime transactionTime;
	private TransactionType transactionType;
	private TransactionDetails transactionDetails; // for now use this later create abstract class and subclasses card,paypal etc
	private Float trasactionAmount;
	private AddressDTO billingAddress;
	
	public TransactionDTO() {}
	
	
	public Float getTrasactionAmount() {
		return trasactionAmount;
	}

	public void setTrasactionAmount(Float trasactionAmount) {
		this.trasactionAmount = trasactionAmount;
	}

	public Long getTransactionID() {
		return transactionID;
	}
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public TransactionDetails getTransactionDetails() {
		return transactionDetails;
	}
	public AddressDTO getBillingAddress() {
		return billingAddress;
	}
	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public void setTransactionDetails(TransactionDetails transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public void setBillingAddress(AddressDTO billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
	
	public static TransactionDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, TransactionDTO.class);
		} catch (JsonProcessingException e) {

			return new TransactionDTO();
		}
	}

	public static TransactionDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	

}

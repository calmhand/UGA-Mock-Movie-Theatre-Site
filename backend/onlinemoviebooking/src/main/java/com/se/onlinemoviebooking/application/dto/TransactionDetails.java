package com.se.onlinemoviebooking.application.dto;

import java.util.Random;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TransactionDetails implements SimpleDTO {

	private String cardNumber;
	private String bankTransactionID;

	public TransactionDetails() {

	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getBankTransactionID() {
		return bankTransactionID;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setBankTransactionID(String bankTransactionID) {
		this.bankTransactionID = bankTransactionID;
	}

	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static TransactionDetails getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, TransactionDetails.class);
		} catch (JsonProcessingException e) {

			return new TransactionDetails();
		}
	}

	public static TransactionDetails getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	
	public static TransactionDetails generateTransaction() {
		TransactionDetails td = new TransactionDetails();
		td.setCardNumber("XXXX1234");
		Random rnd = new Random();
		long n = 1000000000l + rnd.nextLong(9000000000l);
		td.setBankTransactionID(String.valueOf(n));
		return td;
	}

}

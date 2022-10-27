package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class PaymentcardDTO implements SimpleDTO {

	private Integer cardID;

	private String userID;

	private String cardNumber;

	private String cardExpiry;

	private AddressDTO billingAddress;
	
	public PaymentcardDTO() {
		
	}

	public PaymentcardDTO(Integer cardID, String userID, String cardNumber, String cardExpiry,
			AddressDTO billingAddress) {
		super();
		this.cardID = cardID;
		this.userID = userID;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.billingAddress = billingAddress;
	}

	public Integer getCardID() {
		return cardID;
	}

	public String getUserID() {
		return userID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public AddressDTO getBillingAddress() {
		return billingAddress;
	}

	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
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

	public static PaymentcardDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, PaymentcardDTO.class);
		} catch (JsonProcessingException e) {

			return new PaymentcardDTO();
		}
	}

	public static PaymentcardDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	
	

}

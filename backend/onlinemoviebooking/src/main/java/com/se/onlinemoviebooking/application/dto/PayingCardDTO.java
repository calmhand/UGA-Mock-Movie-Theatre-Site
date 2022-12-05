package com.se.onlinemoviebooking.application.dto;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

public class PayingCardDTO implements SimpleDTO {

	private String cardNumber;

	private String cardExpiry;

	private AddressDTO billingAddress;

	private String cc;
	
	public PayingCardDTO() {

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

	public String getCc() {
		return cc;
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

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String toJSONString() {
		try {
			return dtoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static PayingCardDTO getObject(String jsonstr) {
		try {
			return dtoMapper.readValue(jsonstr, PayingCardDTO.class);
		} catch (JsonProcessingException e) {

			return new PayingCardDTO();
		}
	}

	public static PayingCardDTO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}

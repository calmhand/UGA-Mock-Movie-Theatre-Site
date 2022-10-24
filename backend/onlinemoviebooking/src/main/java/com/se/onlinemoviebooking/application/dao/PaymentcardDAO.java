package com.se.onlinemoviebooking.application.dao;

import javax.persistence.*;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;


@Entity
@Table(name="paymentcard")
public class PaymentcardDAO implements SimpleDAO{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @Column(name = "cardid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardID;
	
	@Column(name = "userid")
    private String userID;
	
	@Column(name = "cardnumber")
	private String cardNumber;
	
	@Column(name = "cardexpiry")
	private String cardExpiry;
	
	@Column(name = "billingaddress")
    private String billingAddress;
	
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

	public String getBillingAddress() {
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

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public String toJSONString() {
		try {
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static PaymentcardDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, PaymentcardDAO.class);
		} catch (JsonProcessingException e) {

			return new PaymentcardDAO();
		}
	}

	public static PaymentcardDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}
	
	

}

package com.se.onlinemoviebooking.application.dao;

import javax.persistence.*;


@Entity
@Table(name="paymentcard")
public class PaymentcardDAO implements SimpleDAO{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @Column(name = "cardid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardID;
	
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

	@Column(name = "userid")
    private String userID;
	
	@Column(name = "cardnumber")
	private String cardNumber;
	
	@Column(name = "cardexpiry")
	private String cardExpiry;
	
	@Column(name = "billingaddress")
    private String billingAddress;
	
	

}

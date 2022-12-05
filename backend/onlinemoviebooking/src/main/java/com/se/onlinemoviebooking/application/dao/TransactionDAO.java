package com.se.onlinemoviebooking.application.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name = "transaction")
public class TransactionDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "transactionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionID;
	
	@Column(name = "transaction_time")
	private LocalDateTime transactionTime;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_details")
	private String transactionDetails;
	
	@Column(name = "transaction_amount")
	private Float transactionAmount;
	
	@Column(name = "billing_address")
	private String billingAddress;
	
	public TransactionDAO() {
		
	}
	
	public Float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Long getTransactionID() {
		return transactionID;
	}
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public String getTransactionDetails() {
		return transactionDetails;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
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

	public static TransactionDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, TransactionDAO.class);
		} catch (JsonProcessingException e) {

			return new TransactionDAO();
		}
	}

	public static TransactionDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}

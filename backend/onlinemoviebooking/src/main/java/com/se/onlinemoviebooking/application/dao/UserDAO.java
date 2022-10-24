package com.se.onlinemoviebooking.application.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;

@Entity
@Table(name = "user")
public class UserDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "number")
	private String number;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "issubscribed")
	private Boolean isSubscribed;

	@Column(name = "address")
	private String address;

	@Column(name = "usertype")
	private String userType;

	@Column(name = "statusid")
	private Integer statusID;

	public UserDAO() {
	}

	public UserDAO(Integer userID, String firstName, String lastName, String number, String email, String password,
			Boolean isSubscribed, String address, String userType, Integer statusID) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.email = email;
		this.password = password;
		this.isSubscribed = isSubscribed;
		this.address = address;
		this.userType = userType;
		this.statusID = statusID;
	}

	public Integer getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getIsSubscribed() {
		return isSubscribed;
	}

	public String getAddress() {
		return address;
	}

	public String getUserType() {
		return userType;
	}

	public Integer getStatusID() {
		return statusID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIsSubscribed(Boolean isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}

	public String toJSONString() {
		try {
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static UserDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, UserDAO.class);
		} catch (JsonProcessingException e) {

			return new UserDAO();
		}
	}

	public static UserDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}

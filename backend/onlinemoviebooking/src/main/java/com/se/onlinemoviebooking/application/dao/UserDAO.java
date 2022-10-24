package com.se.onlinemoviebooking.application.dao;

import javax.persistence.*;

@Entity
@Table(name="user")
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
     	
     
}


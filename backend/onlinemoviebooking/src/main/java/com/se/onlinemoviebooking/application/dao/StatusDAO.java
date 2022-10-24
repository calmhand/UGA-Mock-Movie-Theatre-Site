package com.se.onlinemoviebooking.application.dao;

import javax.persistence.*;

public class StatusDAO implements SimpleDAO{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "statusid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusID;
     
    @Column(name = "status")
    private String status;

	public Integer getStatusID() {
		return statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

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
@Table(name = "status")
public class StatusDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "statusid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer statusID;

	@Column(name = "status")
	private String status;

	public StatusDAO() {
	}

	public StatusDAO(Integer statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	}

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

	public String toJSONString() {
		try {
			return daoMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public static StatusDAO getObject(String jsonstr) {
		try {
			return daoMapper.readValue(jsonstr, StatusDAO.class);
		} catch (JsonProcessingException e) {

			return new StatusDAO();
		}
	}

	public static StatusDAO getObject(JSONObject json) {

		return getObject(json.toJSONString());

	}

}

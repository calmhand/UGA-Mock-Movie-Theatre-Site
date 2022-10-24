package com.se.onlinemoviebooking.application.dao;

import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface SimpleDAO extends Serializable{
	
	public final ObjectMapper daoMapper = new ObjectMapper();

}

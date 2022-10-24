package com.se.onlinemoviebooking.application.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface SimpleDTO {
	
	public final ObjectMapper dtoMapper = new ObjectMapper();
	
	//public String toJSONString();
	
	//public T getObject(String jsonstr);
	
	

}

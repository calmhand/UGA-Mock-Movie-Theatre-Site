package com.se.onlinemoviebooking.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.onlinemoviebooking.application.api.ApplicationAPIHandler;


@Controller
public class ApiController {

	@RequestMapping("/")
	@ResponseBody
    public String home(){
        return "working";
    }
	
	@RequestMapping("/hello")
	@ResponseBody
    public String hello(){
        return "<center><h1>Hello Jay</h1></center>";
    }
	
	//registration api
	
	/*
	 payload  can be
	 {
		"name":"jayasimha"
		"email": "myemail@gmail.com"
		"password":"mypassword"
		"confirmPassword":"mypassword"
		"address": "gaines shool road"
		"optForPromotions":false
	}
	 */
	@RequestMapping(method = RequestMethod.POST, value="/user/register")
	@ResponseBody
	public JSONObject registerUser(HttpServletRequest request,@RequestBody JSONObject payload) {
		return  ApplicationAPIHandler.registerUser(payload);
	}
}

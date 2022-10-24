package com.se.onlinemoviebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
	
	
}

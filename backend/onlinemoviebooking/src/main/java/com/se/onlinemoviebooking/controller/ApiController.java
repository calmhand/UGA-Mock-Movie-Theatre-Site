package com.se.onlinemoviebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/messages")
public class ApiController {	
	
	@ResponseBody
    public String home(){
        return "working";
    }
	
	@GetMapping("/hello")
    public String hello() {
        return "hello";
    }
	
	
}

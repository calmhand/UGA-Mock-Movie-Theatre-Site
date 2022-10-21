package com.se.onlinemoviebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.se.onlinemoviebooking.controller"})
public class OnlinemoviebookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinemoviebookingApplication.class, args);
	}

}

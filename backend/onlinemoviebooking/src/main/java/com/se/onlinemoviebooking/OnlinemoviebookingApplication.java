package com.se.onlinemoviebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class OnlinemoviebookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinemoviebookingApplication.class, args);
	}
	
	
	
	
// cors mapping: we can use specifics like registry.addMapping("/user/register").allowedOrigins("http://localhost:3000");
//I'll add this later keep it like below which allows all mapping from all origins for now here

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}

}

package com.se.onlinemoviebooking.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@ComponentScan
public class WebConfig implements WebMvcConfigurer{
	
	
	
	// cors mapping: we can use specifics like registry.addMapping("/user/register").allowedOrigins("http://localhost:3000");
	//I'll add this later keep it like below which allows all mapping from all origins for now.
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}

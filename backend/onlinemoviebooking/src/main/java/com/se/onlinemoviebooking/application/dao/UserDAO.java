package com.se.onlinemoviebooking.application.dao;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserDAO implements SimpleDAO {

	private static final long serialVersionUID = 1L;
	
	
	@Id
    @Column(name = "movieid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(name = "name", length = 128, nullable = false, unique = false)
    private String name;
     
    @Column(name = "email", length = 128, nullable = false, unique = true) //dont allow multiple registrations with same email
    private String email;
    
    @Column(name = "password", length = 128, nullable = false, unique = false)
    private String password;
    
    @Column(name = "address", length = 128, nullable = false, unique = false)
    private String address;
     
    @Column(name = "duration", nullable = false, unique = false)
    private int durationInMin;
     
    
    
    
    //getters and setters
    //forming dto objects
}


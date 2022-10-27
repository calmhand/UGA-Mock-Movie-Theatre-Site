package com.se.onlinemoviebooking.application.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.onlinemoviebooking.application.dao.UserDAO;


public interface UserRepository extends JpaRepository<UserDAO,Long>{
	
	@Query("SELECT u FROM UserDAO u WHERE u.email = ?1")
    public UserDAO findByEmail(String email);

}

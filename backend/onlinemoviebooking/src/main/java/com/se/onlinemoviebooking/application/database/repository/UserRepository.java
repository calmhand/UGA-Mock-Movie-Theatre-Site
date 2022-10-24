package com.se.onlinemoviebooking.application.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.se.onlinemoviebooking.application.dao.UserDAO;


public interface UserRepository extends JpaRepository<UserDAO,Long>{

}

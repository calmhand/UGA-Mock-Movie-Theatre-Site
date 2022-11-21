package com.se.onlinemoviebooking.application.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.se.onlinemoviebooking.application.dao.UserDAO;

public interface UserRepository extends JpaRepository<UserDAO, Long> {
	
	
	@Query("select u from UserDAO u")
    public List<UserDAO> getAllUsers();

	@Query("SELECT u FROM UserDAO u WHERE u.userID = ?1")
	public UserDAO findByuserid(Integer userid);

	@Query("SELECT u FROM UserDAO u WHERE u.email = ?1")
	public UserDAO findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update UserDAO u set u.password = ?1 WHERE u.userID = ?2")
	public int updatePassword(String password, Integer userid);
	
	@Transactional
	@Modifying
	@Query("update UserDAO u set u.statusID = ?1 WHERE u.userID = ?2")
	public int updateStatus(Integer statusID, Integer userID);

	@Transactional
	@Modifying
	@Query("update UserDAO u set u.firstName = ?1, u.lastName = ?2, u.number = ?3, u.isSubscribed = ?4, u.address = ?5, u.userType = ?6, u.statusID = ?7 where u.userID = ?8")
	public int updateUserDAO(String firstname, String lastname, String number, boolean isSubscribed, String address,
			String usertype, Integer statusid, Integer userid);

}

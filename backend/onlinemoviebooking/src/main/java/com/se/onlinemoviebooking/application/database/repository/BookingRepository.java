package com.se.onlinemoviebooking.application.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.onlinemoviebooking.application.dao.BookingDAO;

public interface BookingRepository extends JpaRepository<BookingDAO, Long> {

	@Query("SELECT b FROM BookingDAO b WHERE b.userID = ?1")
	public List<BookingDAO> getBookingsByuser(Long userID);
	
	//public Join<BookingDAO, MovieDAO> getjoins();

}

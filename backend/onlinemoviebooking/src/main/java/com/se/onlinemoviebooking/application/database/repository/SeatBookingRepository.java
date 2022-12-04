package com.se.onlinemoviebooking.application.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.onlinemoviebooking.application.dao.SeatBookingDAO;

public interface SeatBookingRepository extends JpaRepository<SeatBookingDAO, Long> {

	@Query("select sb from SeatBookingDAO sb")
	public List<SeatBookingDAO> getAllSeatBookings();
	
	@Query("SELECT sb from SeatBookingDAO sb where sb.showID = ?1")
	public SeatBookingDAO getSeatBookingDetailByShowId(Long showID);

}

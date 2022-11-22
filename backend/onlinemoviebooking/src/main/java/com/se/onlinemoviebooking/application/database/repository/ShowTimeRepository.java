package com.se.onlinemoviebooking.application.database.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.se.onlinemoviebooking.application.dao.ShowTimeDAO;

public interface ShowTimeRepository extends JpaRepository<ShowTimeDAO, Long> {
	
	@Query("select s from ShowTimeDAO s")
    public List<ShowTimeDAO> getAllShowTimes();
	
	@Query("select s from ShowTimeDAO s where s.showDate = :date")
    public List<ShowTimeDAO> getShowTimesByDate(@Param("date") Date date);
	
	@Query("select s from ShowTimeDAO s where s.movieID = :movieID")
    public List<ShowTimeDAO> getShowTimesByMovie(@Param("movieID") Long movieID);
	
	@Query("select s from ShowTimeDAO s where s.movieID = :movieID and s.showDate = :date")
    public List<ShowTimeDAO> getShowTimesByDateAndMovie(@Param("movieID") Long movieID,@Param("date") Date date );

}

package com.se.onlinemoviebooking.application.database.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.se.onlinemoviebooking.application.dao.MovieDAO;

public interface MovieRepository extends JpaRepository<MovieDAO, Long> {
	
	@Query("select m from MovieDAO m")
    public List<MovieDAO> getAllMovies();
	
	@Query("SELECT m FROM MovieDAO m WHERE m.title = ?1")
	public List<MovieDAO> findByName(String name);
	
	@Query("select m from MovieDAO m where m.releaseDate > :date")
    public List<MovieDAO> getUpcomingMovies(@Param("date") Date date);
	
	@Transactional
	@Modifying
	@Query("update MovieDAO m set m.title = ?1, m.category = ?2, m.rating = ?3, m.releaseDate = ?4, m.director = ?5, m.producer = ?6, m.cast = ?7, m.synopsis = ?8, m.posterURL = ?9, m.trailerURL = ?10 where m.movieID = ?11")
	public int updateMovieDAO(String title, String category, String rating, Date releaseDate, String director,
			String producer, String cast, String synopsis, String posterURL, String trailerURL, Long movieid);

}





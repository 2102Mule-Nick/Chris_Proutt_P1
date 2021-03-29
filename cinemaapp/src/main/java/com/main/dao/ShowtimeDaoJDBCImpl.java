package com.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ShowtimeRowMapper;
import com.main.pojo.Movie;
import com.main.pojo.Showtime;
import com.main.pojo.Theater;

@Repository
public class ShowtimeDaoJDBCImpl implements ShowtimeDao {

	@Autowired
	Logger log;
	
	private JdbcTemplate template;
	
	private ShowtimeRowMapper mapper;
	
	@Override
	public void createShowtime(Showtime showtime) {
		log.trace("Creating a showtime");
		
		String sql = "insert into showtimes (theater_id, screen_id, movie_id, showing_time, showing_date) values (?, ?, ?, ?, ?)";
		
		template.update(sql, showtime.getTheater_id(), showtime.getScreen_id(), showtime.getMovie_id(), showtime.getShowing_time(), showtime.getShowing_date());
	}

	@Override
	public void deleteShowtime(Showtime showtime) {
		log.trace("Deleting a showtime");
		
		String sql = "delete from showtimes where showtime_id = ?";				
		
		template.update(sql, showtime.getShowtime_id());
	}

	@Override
	public Showtime getShowtimeByShowTimeId(int id) {
		log.trace("Getting showtime by Id");
		
		String sql = "select * from showtimes where showtime_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, id);
		
		return showtimeList.get(0);
	}

	@Override
	public List<Showtime> getAllShowTimesAtAtheater(Theater theater) {
		log.trace("Getting all showtimes at a theater");
		
		String sql = "select * from showtimes where theater_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, theater.getTheater_id());
		
		return showtimeList;
	}

	@Override
	public List<Showtime> getAllShowTimeByMovie(Movie movie) {
		log.trace("Getting all showtimes by Movie");
		
		String sql = "select * from showtimes where movie_id = ?";

		List<Showtime> showtimesList = template.query(sql, mapper, movie.getMovie_id());
		
		return showtimesList;
	}

}

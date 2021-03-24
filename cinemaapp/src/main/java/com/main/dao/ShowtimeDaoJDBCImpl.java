package com.main.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.main.dao.mapper.ShowtimeRowMapper;
import com.main.pojo.Movie;
import com.main.pojo.Showtime;
import com.main.pojo.Theater;

public class ShowtimeDaoJDBCImpl implements ShowtimeDao {

	private JdbcTemplate template;
	
	private ShowtimeRowMapper mapper;
	
	@Override
	public void createShowtime(Showtime showtime) {
		String sql = "insert into showtimes";
		
	}

	@Override
	public void deleteShowtime(Showtime showtime) {
		// TODO Auto-generated method stub

	}

	@Override
	public Showtime getShowtimeByShowTimeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Showtime> getAllShowTimesAtAtheater(Theater theater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Showtime> getAllShowTimeByMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

}

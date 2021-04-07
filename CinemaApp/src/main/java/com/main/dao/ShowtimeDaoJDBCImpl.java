package com.main.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ShowtimeRowMapper;
import com.main.pojo.Showtime;

@Repository
public class ShowtimeDaoJDBCImpl implements ShowtimeDao {

	@Autowired
	Logger log;
	
	private JdbcTemplate template;
	
	private ShowtimeRowMapper mapper;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ShowtimeRowMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(ShowtimeRowMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Showtime createShowtime(Showtime showtime) {		
		String sql = "insert into showtimes (theater_id, screen_id, movie_id, showing_time, showing_date) values (?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, showtime.getTheater_id());
			ps.setInt(2, showtime.getScreen_id());
			ps.setInt(3, showtime.getMovie_id());
			ps.setTime(4, showtime.getShowing_time());
			ps.setDate(5, showtime.getShowing_date());
			return ps;
		}, keyHolder);
		
		showtime.setShowtime_id((int)keyHolder.getKeys().get("showtime_id"));
		
		return showtime;
	}

	@Override
	public void deleteShowtime(int showtimeId) {
		log.trace("Deleting a showtime");
		
		String sql = "delete from showtimes where showtime_id = ?";				
		
		template.update(sql, showtimeId);
	}

	@Override
	public Showtime getShowtimeByShowTimeId(int id) {		
		String sql = "select * from showtimes where showtime_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, id);
		
		return showtimeList.get(0);
	}

	@Override
	public List<Showtime> getAllShowTimesAtAtheater(int id) {		
		String sql = "select * from showtimes where theater_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, id);
		
		return showtimeList;
	}

	@Override
	public List<Showtime> getAllShowTimeByMovie(int id) {		
		String sql = "select * from showtimes where movie_id = ?";

		List<Showtime> showtimesList = template.query(sql, mapper, id);
		
		return showtimesList;
	}

}

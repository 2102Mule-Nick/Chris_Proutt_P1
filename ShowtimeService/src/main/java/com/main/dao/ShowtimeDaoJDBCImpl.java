package com.main.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.ShowtimeRowMapper;
import com.main.pojo.Showtime;

@Repository
public class ShowtimeDaoJDBCImpl implements ShowtimeDao {
	
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

	// Create
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

	// Reads
	@Override
	public Showtime getShowtimeByShowTimeId(int id) {		
		String sql = "select * from showtimes where showtime_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, id);
		
		return showtimeList.get(0);
	}

	@Override
	public List<Showtime> getAllShowTimeByMovie(int id) {		
		String sql = "select * from showtimes where movie_id = ?";

		List<Showtime> showtimesList = template.query(sql, mapper, id);
		
		return showtimesList;
	}

	@Override
	public List<Showtime> getAllShowtimes() {
		String sql = "select * from showtimes";
		
		List<Showtime> showtimeList = template.query(sql, mapper);
		
		return showtimeList;
	}

	@Override
	public List<Showtime> getAllShowTimesByTheater(int theaterid) {
		String sql = "select * from showtimes where theater_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, theaterid);
		
		return showtimeList;
	}

	@Override
	public List<Showtime> getAllShowtimesByScreen(int screenId) {
		String sql = "select * from showtimes where screen_id = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, screenId);
		
		return showtimeList;
	}

	@Override
	public List<Showtime> getShowtimeByTime(Time time) {
		String sql = "select * from showtimes where showing_time = ?";
		
		List<Showtime> showtimeList = template.query(sql, mapper, time);
		
		return showtimeList;
	}

	@Override
	public List<Showtime> getShowtimeByDate(Date date) {
		String sql = "select * from showtimes where showing_date = ?";
		
		return template.query(sql, mapper, date);
	}
	
	@Override
	public void updateShowingTime(int showtimeId, Time time) {
		String sql = "update showtimes set showing_time = ? where showtime_id = ?";
		
		template.update(sql, time, showtimeId);
	}

	@Override
	public void updateShowingDate(int showtimeId, Date date) {
		String sql = "update showtimes set showing_date = ? where showtime_id = ?";
		
		template.update(sql, date, showtimeId);		
	}

	@Override
	public void deleteAllShowtimes() {
		String sql = "delete from showtimes";
		
		template.update(sql);
	}

	@Override
	public void deleteAllTimesByDate(Date date) {
		String sql = "delete from showtime where showing_date = ?";
		
		template.update(sql, date);
	}
	
	@Override
	public void deleteShowtime(int showtimeId) {
		
		String sql = "delete from showtimes where showtime_id = ?";				
		
		template.update(sql, showtimeId);
	}

}

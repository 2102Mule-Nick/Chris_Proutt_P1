package com.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.SeatRowMapper;
import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Theater;

@Repository
public class SeatDaoImpl implements SeatDao {

	@Autowired
	Logger log;
	
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public SeatRowMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(SeatRowMapper mapper) {
		this.mapper = mapper;
	}

	private SeatRowMapper mapper;
	
	@Override
	public void createSeat(Seat seat) {
		log.trace("Creating a seat.");
		
		String sql = "insert into seats (user_id, theater_id, movie_id, screen_id, availability, accessible, seat_number) values (?, ?, ?, ?, ?, ?, ?)";
		
		template.update(sql, seat.getUser_id(), seat.getTheater_id(), seat.getMovie_id(), seat.getScreen_id(), seat.isAvailable(), seat.isAccessible(), seat.getSeat_number());
	}

	@Override
	public void deleteSeat(Seat seat) {
		log.trace("Deleting a seat from a theater");

		String sql = "delete from seats where seat_id = ?";
		
		template.update(sql, seat.getSeat_id());
	}

	@Override
	public Seat getSeatBySeatId(int id) {
		log.trace("Getting seat by ID");
		
		String sql = "select * from seats where seat_id = ?";
		
		List<Seat> seatList = template.query(sql, mapper, id);
		return seatList.get(0);
	}

	@Override
	public List<Seat> getAllSeatsInTheater(Theater theater) {
		log.trace("Getting all seats in a theater");
		
		String sql = "select * from seats where theater_id = ?";
		
		List<Seat> seatList = template.query(sql, mapper, theater.getTheater_id());
		
		return seatList;
	}
	
	@Override
	public List<Seat> getAllSeatsInScreen(Screen screen){
		log.trace("Getting all seats in a screen");
		
		String sql = "select * from seats where screen_id = ?";
		
		List<Seat> seatList = template.query(sql, mapper, screen.getScreen_id());
		
		return seatList;
	}

}

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

import com.main.dao.mapper.SeatRowMapper;
import com.main.pojo.Seat;

@Repository
public class SeatDaoImpl implements SeatDao {
	
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
	public Seat createSeat(Seat seat) {
		String sql = "insert into seats (theater_id, screen_id, availability, accessible, seat_number) values (?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, seat.getTheater_id());
			ps.setInt(2, seat.getScreen_id());
			ps.setBoolean(3, seat.isAvailable());
			ps.setBoolean(4, seat.isAccessible());
			ps.setString(5, seat.getSeat_number());
			return ps;
		}, keyHolder);
	
		seat.setSeat_id((int)keyHolder.getKeys().get("seat_id"));
	
		return seat;
	
	}

	@Override
	public void deleteSeat(int id) {
		String sql = "delete from seats where seat_id = ?";
		
		template.update(sql, id);
	}

	@Override
	public Seat getSeatBySeatId(int id) {
		String sql = "select * from seats where seat_id = ?";
		
		List<Seat> seatList = template.query(sql, mapper, id);
		return seatList.get(0);
	}

	@Override
	public List<Seat> getAllSeatsInTheater(int id) {		
		String sql = "select * from seats where theater_id = ?";
		
		List<Seat> seatList = template.query(sql, mapper, id);
		
		return seatList;
	}
	
	@Override
	public List<Seat> getAllSeatsInScreen(int id){		
		String sql = "select * from seats where screen_id = ?";
		
		List<Seat> seatList = template.query(sql, mapper, id);
		
		return seatList;
	}

	@Override
	public void makeSeatAvailable(int id) {
		String sql = "update seats set availability = true where seat_id = ?";
		
		template.update(sql, id);
	}

	@Override
	public void makeSeatUnavailable(int id) {
		String sql = "update seats set availability = false where seat_id = ?";
		
		template.update(sql, id);
	}

	@Override
	public void makeSeatAccessible(int id) {
		String sql = "update seats set accesible = true where seat_id = ?";
		
		template.update(sql, id);
	}

	@Override
	public List<Seat> getAllSeat() {
		String sql = "select * from seats";
		
		List<Seat> seatList = template.query(sql, mapper);
		
		return seatList;
	}

}

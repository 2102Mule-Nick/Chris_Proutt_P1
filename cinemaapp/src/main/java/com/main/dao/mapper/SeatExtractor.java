package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Seat;

@Component
public class SeatExtractor implements ResultSetExtractor<Seat> {

	@Override
	public Seat extractData(ResultSet rs) throws SQLException, DataAccessException {
		Seat seat = new Seat();
		
		seat.setSeat_id(rs.getInt("seat_id"));
		seat.setUser_id(rs.getInt("user_id"));
		seat.setTheater_id(rs.getInt("theater_id"));
		seat.setMovie_id(rs.getInt("movie_id"));
		seat.setScreen_id(rs.getInt("screen_id"));
		seat.setAvailable(rs.getBoolean("availability"));
		seat.setAccessible(rs.getBoolean("accesible"));
		seat.setSeat_number(rs.getString("seat_number"));
		
		return seat;
	}

}

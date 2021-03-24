package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Showtime;

@Component
public class ShowtimeExtractor implements ResultSetExtractor<Showtime> {

	@Override
	public Showtime extractData(ResultSet rs) throws SQLException, DataAccessException {
		Showtime showtime = new Showtime();
		
		showtime.setTheater_id(rs.getInt("theater_id"));
		showtime.setScreen_id(rs.getInt("screen_id"));
		showtime.setMovie_id(rs.getInt("movie_id"));
		showtime.setShowing_time(rs.getTime("showing_time"));
		showtime.setShowing_date(rs.getDate("date"));
		
		return showtime;
	}

}

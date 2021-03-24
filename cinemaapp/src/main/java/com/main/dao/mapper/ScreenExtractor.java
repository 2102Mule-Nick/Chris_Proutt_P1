package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.main.pojo.Screen;

public class ScreenExtractor implements ResultSetExtractor<Screen> {

	@Override
	public Screen extractData(ResultSet rs) throws SQLException, DataAccessException {
		Screen screen = new Screen();
		
		screen.setScreen_id(rs.getInt("screen_id"));
		screen.setTheater_id(rs.getInt("theater_id"));
		screen.setCapacity(rs.getInt("capacity"));
		screen.setScreen_type(rs.getString("screen_type"));
		
		return screen;
	}

}

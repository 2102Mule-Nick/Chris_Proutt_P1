package com.main.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Screen;

@Component
public class ScreenExtractor implements ResultSetExtractor<Screen> {

	public Screen extractData(ResultSet rs) throws SQLException, DataAccessException {
		Screen screen = new Screen();
		
		screen.setScreen_id(rs.getInt("screen_id"));
		screen.setTheater_id(rs.getInt("theater_id"));
		screen.setCapacity(rs.getInt("capacity"));
		screen.setScreen_type(rs.getString("screen_type"));
		screen.setScreen_name(rs.getString("screen_name"));
		
		return screen;
	}
	
}

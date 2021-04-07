package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Theater;

@Component
public class TheaterExtractor implements ResultSetExtractor<Theater> {

	@Override
	public Theater extractData(ResultSet rs) throws SQLException, DataAccessException {
		Theater theater = new Theater();
		
		theater.setTheaterName(rs.getString("theater_name"));
		theater.setAddress(rs.getString("theater_address"));
		theater.setTheater_id(rs.getInt("theater_id"));	
		theater.setNum_of_screens(rs.getInt("num_of_screens"));
		theater.setZipcode(rs.getString("zip_code"));
		
		return theater;
	}

}

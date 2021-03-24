package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.main.pojo.Showtime;

public class ShowtimeRowMapper implements RowMapper<Showtime> {

	private ShowtimeExtractor extractor ;
	
	@Override
	public Showtime mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

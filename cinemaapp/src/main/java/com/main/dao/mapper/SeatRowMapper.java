package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.pojo.Seat;

@Component
public class SeatRowMapper implements RowMapper<Seat> {

	private SeatExtractor extractor;
	
	@Override
	public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

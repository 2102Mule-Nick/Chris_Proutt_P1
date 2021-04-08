package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.dao.extractor.SeatExtractor;
import com.main.pojo.Seat;

@Component
public class SeatRowMapper implements RowMapper<Seat> {

	private SeatExtractor extractor;
	
	@Autowired
	public void setExtractor(SeatExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

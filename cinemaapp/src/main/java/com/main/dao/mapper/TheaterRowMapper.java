package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.main.pojo.Theater;

public class TheaterRowMapper implements RowMapper<Theater> {

	private TheaterExtractor extractor;
	
	@Override
	public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

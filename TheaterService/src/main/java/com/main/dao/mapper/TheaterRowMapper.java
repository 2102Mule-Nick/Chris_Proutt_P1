package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.dao.extractor.TheaterExtractor;
import com.main.pojo.Theater;

@Component
public class TheaterRowMapper implements RowMapper<Theater> {

	public void setExtractor(TheaterExtractor extractor) {
		this.extractor = extractor;
	}

	@Autowired
	private TheaterExtractor extractor;
	
	@Override
	public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

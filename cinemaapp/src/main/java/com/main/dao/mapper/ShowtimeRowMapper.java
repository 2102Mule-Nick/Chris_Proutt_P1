package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.pojo.Showtime;

@Component
public class ShowtimeRowMapper implements RowMapper<Showtime> {

	private ShowtimeExtractor extractor ;
	
	@Autowired
	public void setExtractor(ShowtimeExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public Showtime mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

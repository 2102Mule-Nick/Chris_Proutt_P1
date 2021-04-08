package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.dao.extractor.ScreenExtractor;
import com.main.pojo.Screen;

@Component
public class ScreenRowMapper implements RowMapper<Screen> {

	private ScreenExtractor extractor;
	
	@Autowired
	public void setExtractor(ScreenExtractor extractor) {
		this.extractor = extractor;
	}

	public Screen mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}


}

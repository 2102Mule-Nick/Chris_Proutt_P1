package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.pojo.MovieCharacter;

@Component
public class CharacterRowMapper implements RowMapper<MovieCharacter> {

	private CharacterExtractor extractor;
	
	@Autowired
	public void setExtractor(CharacterExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public MovieCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
		extractor.extractData(rs);
		
		return null;
	}

}

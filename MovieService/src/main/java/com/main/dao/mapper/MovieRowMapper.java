package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.dao.extractor.MovieExtractor;
import com.main.pojo.Movie;

@Component
public class MovieRowMapper implements RowMapper<Movie> {

	private MovieExtractor extractor;
	
	@Autowired
	public void setExtractor(MovieExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

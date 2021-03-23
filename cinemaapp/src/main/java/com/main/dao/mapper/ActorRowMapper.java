package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.main.pojo.Actor;

public class ActorRowMapper implements RowMapper<Actor> {

	private ActorExtractor extractor;
	
	@Override
	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

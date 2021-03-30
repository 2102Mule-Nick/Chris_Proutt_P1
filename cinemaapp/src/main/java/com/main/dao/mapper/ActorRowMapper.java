package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.pojo.Actor;

@Component
public class ActorRowMapper implements RowMapper<Actor> {

	private ActorExtractor extractor;
	
	@Autowired
	public void setExtractor(ActorExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

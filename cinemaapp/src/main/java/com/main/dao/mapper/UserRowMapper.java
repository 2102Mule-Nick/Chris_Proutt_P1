package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.pojo.User;

@Component
public class UserRowMapper implements RowMapper<User> {

	private UserExtractor extractor;
	
	public void setExtractor(UserExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

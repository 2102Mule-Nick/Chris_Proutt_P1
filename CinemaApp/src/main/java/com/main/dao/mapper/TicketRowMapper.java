package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.main.pojo.Ticket;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

	private TicketExtractor extractor;
	
	@Autowired
	public void setExtractor(TicketExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		return extractor.extractData(rs);
	}

}

package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Ticket;

@Component
public class TicketCreationExtractor implements ResultSetExtractor<Ticket> {

	@Override
	public Ticket extractData(ResultSet rs) throws SQLException, DataAccessException {
		Ticket ticket = new Ticket();
		ticket.setTicket_id(rs.getInt("ticket_id"));
		ticket.setUser_id(rs.getInt("user_id"));
		ticket.setTheater_id(rs.getInt("theater_id"));
		ticket.setMovie_id(rs.getInt("movie_id"));
		ticket.setSeat_id(rs.getInt("seat_id"));
		ticket.setScreen_id(rs.getInt("screen_id"));
		return ticket;
	}

}

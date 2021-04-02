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
		ticket.setUser_first_name(rs.getString("first_name"));
		ticket.setUser_last_name(rs.getString("last_name"));
		ticket.setTheater_id(rs.getInt("theater_id"));
		ticket.setTheater_name(rs.getString("theater_name"));
		ticket.setTheater_address(rs.getString("theater_address"));
		ticket.setMovie_id(rs.getInt("movie_id"));
		ticket.setTitle(rs.getString("title"));
		ticket.setRuntime(rs.getTime("runtime"));
		ticket.setDate(rs.getDate("date"));
		ticket.setShowtime(rs.getTime("showing_time"));
		ticket.setSeat_id(rs.getInt("seat_id"));
		ticket.setSeat_number(rs.getString("seat_number"));
		ticket.setScreen_id(rs.getInt("screen_id"));
		ticket.setScreen_name(rs.getString("screen_name"));
		return ticket;
	}

}

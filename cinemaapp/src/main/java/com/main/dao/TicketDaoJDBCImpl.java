package com.main.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.main.dao.mapper.TicketRowMapper;
import com.main.pojo.Ticket;
import com.main.pojo.User;

public class TicketDaoJDBCImpl implements TicketDao {

	private JdbcTemplate template;
	
	private TicketRowMapper mapper;
	
	@Override
	public void createTicket(Ticket ticket) {
		String sql = "insert into tickets (user_id, theater_id, movie_id, seat_id, screen_id) value (?, ?, ?, ?, ?)";
		
		template.update(sql, ticket.getUser_id(), ticket.getTheater_id(), ticket.getMovie_id(), ticket.getSeat_id(), ticket.getScreen_id());
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		String sql = "delete from rickets where ticket_id = ?";
		
		template.update(sql, ticket.getTicket_id());
	}

	@Override
	public Ticket getTicketForUser(User user) {
		String sql = "select * from tickets where user_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, user.getUser_id());
		
		return ticketList.get(0);
	}

	@Override
	public List<Ticket> getAllTicketsFromUser(User user) {
		String sql = " select * from tickets where user_id = *";
		
		List<Ticket> ticketList = template.query(sql, mapper, user.getUser_id());
		
		return ticketList;
	}

}

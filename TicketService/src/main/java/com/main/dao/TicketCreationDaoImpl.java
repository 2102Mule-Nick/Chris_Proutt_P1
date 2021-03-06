package com.main.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.TicketCreationRowMapper;
import com.main.dao.mapper.TicketInfoRowMapper;
import com.main.pojo.Ticket;

@Repository
public class TicketCreationDaoImpl implements TicketCreation {

	public TicketCreationDaoImpl() {
		super();
	}

	private JdbcTemplate template;
	
	private TicketCreationRowMapper mapper;
	
	private TicketInfoRowMapper InfoMapper;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setMapper(TicketCreationRowMapper mapper) {
		this.mapper = mapper;
	}

	public TicketInfoRowMapper getInfoMapper() {
		return InfoMapper;
	}

	@Autowired
	public void setInfoMapper(TicketInfoRowMapper infoMapper) {
		InfoMapper = infoMapper;
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		String sql = "insert into tickets (user_id, theater_id, movie_id, seat_id, screen_id) values (?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ticket.getUser_id());
			ps.setInt(2, ticket.getTheater_id());
			ps.setInt(3, ticket.getMovie_id());
			ps.setInt(4, ticket.getSeat_id());
			ps.setInt(5, ticket.getScreen_id());
			return ps;
		}, keyHolder);
		
		ticket.setTicket_id((int)keyHolder.getKeys().get("ticket_id"));
		
		return ticket;
	}

	@Override
	public void deleteTicket(int id) {
		String sql = "delete from tickets where ticket_id = ?";

		template.update(sql, id);
	}

	@Override
	public Ticket getTicketById(int id) {
		String sql = "select * from tickets where ticket_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList.get(0);
	}

	@Override
	public List<Ticket> getAllTickets() {
		String sql = "select * from tickets";
		
		List<Ticket> ticketList = template.query(sql, mapper);
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsForMovieId(int id) {
		String sql = "select * from tickets where movie_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketForScreenId(int id) {
		String sql = "select * from tickets where screen_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsByTheaterId(int id) {
		String sql = "select * from ticket where theater_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsForSeatId(int id) {
		String sql = "select * from ticket where seat_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsForUserId(int id) {
		String sql = "select * from ticket where user_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList;
	}

	@Override
	public Ticket getTicketInformation(int id) {
		
		String sql = "select ti.ticket_id, u.first_name, u.last_name, th.theater_name, th.theater_address, m.title, m.runtime, st.date, st.showing_time, s.seat_number, s2.screen_name from tickets ti"
				+ "	inner join users u on u.user_id = ti.user_id"
				+ "	inner join theater th on ti.theater_id = th.theater_id"
				+ "	inner join movies m on m.movie_id = ti.movie_id"
				+ "	inner join seats s on s.seat_id = ti.seat_id"
				+ "	inner join screen s2 on s2.screen_id = ti.screen_id"
				+ "	inner join showtimes st on st.movie_id = ti.movie_id"
				+ " where ti.ticket_id = ?";
		
		List<Ticket> ticketList = template.query(sql, InfoMapper, id);
		
		return ticketList.get(0);
	}	
	

}

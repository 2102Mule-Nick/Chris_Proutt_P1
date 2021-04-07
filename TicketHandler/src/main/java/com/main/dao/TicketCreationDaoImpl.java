package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.TicketCreationRowMapper;
import com.main.dao.mapper.TicketInfoRowMapper;
import com.main.pojo.Movie;
import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;
import com.main.pojo.User;

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
	public void createTicket(Ticket ticket) {
		String sql = "insert into tickets (user_id, theater_id, movie_id, seat_id, screen_id) values (?, ?, ?, ?, ?)";
		
		template.update(sql, ticket.getUser_id(), ticket.getTheater_id(), ticket.getMovie_id(), ticket.getSeat_id(), ticket.getScreen_id());
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		String sql = "delete from tickets where ticket_id = ?";

		template.update(sql, ticket.getTicket_id());
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
	public List<Ticket> getAllTicketsForMovie(Movie movie) {
		String sql = "select * from tickets where movie_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, movie.getMovie_id());
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketForScreen(Screen screen) {
		String sql = "select * from tickets where screen_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, screen.getScreen_id());
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsByTheaterId(int id) {
		String sql = "select * from ticket where theater_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, id);
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsForSeat(Seat seat) {
		String sql = "select * from ticket where seat_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, seat.getSeat_id());
		
		return ticketList;
	}

	@Override
	public List<Ticket> getAllTicketsForUser(User user) {
		String sql = "select * from ticket where user_id = ?";
		
		List<Ticket> ticketList = template.query(sql, mapper, user.getUser_id());
		
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

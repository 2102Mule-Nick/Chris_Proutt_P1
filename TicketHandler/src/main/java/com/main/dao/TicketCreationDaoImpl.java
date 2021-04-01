package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.TicketCreationRowMapper;
import com.main.pojo.Movie;
import com.main.pojo.Screen;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;

@Repository
public class TicketCreationDaoImpl implements TicketCreation {

	private JdbcTemplate template;
	
	private TicketCreationRowMapper mapper;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setMapper(TicketCreationRowMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void createTicket(Ticket ticket) {
		String sql = "";
		
		template.update(sql);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ticket getTicketById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTicketsForMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTicketForScreen(Screen screen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getAllTicketForTheater(Theater theater) {
		// TODO Auto-generated method stub
		return null;
	}

}

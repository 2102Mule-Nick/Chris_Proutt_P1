package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.TicketCreation;
import com.main.pojo.Movie;
import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Showtime;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;
import com.main.pojo.User;

@Service
public class TicketHandlerServiceImpl implements TicketHandlerService {

	private TicketCreation ticketdao;
	
	public TicketHandlerServiceImpl(TicketCreation ticketdao) {
		this.ticketdao = ticketdao;
	}

	public TicketCreation getTicketdao() {
		return ticketdao;
	}

	@Autowired
	public void setTicketdao(TicketCreation ticketdao) {
		this.ticketdao = ticketdao;
	}

	@Override
	public void createTicket(Ticket ticket) {
		ticketdao.createTicket(ticket);

	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketdao.deleteTicket(ticket);
	}

	@Override
	public Ticket getTicketbyId(int id) {
		return ticketdao.getTicketById(id);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketdao.getAllTickets();
	}

	@Override
	public List<Ticket> getAllTicketsByUser(User user) {
		return ticketdao.getAllTicketsForUser(user);
	}

	@Override
	public List<Ticket> getAllTicketsByMovie(Movie movie) {
		return ticketdao.getAllTicketsForMovie(movie);
	}

	@Override
	public List<Ticket> getAllTicketsByScreen(Screen screen) {
		return ticketdao.getAllTicketForScreen(screen);
	}

	@Override
	public List<Ticket> getAllTicketsBySeat(Seat seat) {
		return ticketdao.getAllTicketsForSeat(seat);
	}

	@Override
	public List<Ticket> getAllTicketsByTheater(Theater theater) {
		return ticketdao.getAllTicketForTheater(theater);
	}

	@Override
	public Ticket getTicketInformation(int id) {
		return ticketdao.getTicketInformation(id);
	}

}

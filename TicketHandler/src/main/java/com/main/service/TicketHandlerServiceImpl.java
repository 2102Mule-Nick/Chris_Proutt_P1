package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.TicketCreation;
import com.main.pojo.Ticket;

@Service
public class TicketHandlerServiceImpl implements TicketHandlerService {

	public TicketHandlerServiceImpl() {
		super();
	}

	private TicketCreation ticketdao;
	
	@Autowired
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
	public Ticket createTicket(Ticket ticket) {		
		ticketdao.createTicket(ticket);
		
		return ticket;
	}

	@Override
	public void deleteTicket(int id) {
		ticketdao.deleteTicket(id);
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
	public List<Ticket> getAllTicketsByUser(int id) {
		return ticketdao.getAllTicketsForUserId(id);
	}

	@Override
	public List<Ticket> getAllTicketsByMovie(int id) {
		return ticketdao.getAllTicketsForMovieId(id);
	}

	@Override
	public List<Ticket> getAllTicketsByScreen(int id) {
		return ticketdao.getAllTicketForScreenId(id);
	}

	@Override
	public List<Ticket> getAllTicketsBySeat(int id) {
		return ticketdao.getAllTicketsForSeatId(id);
	}

	@Override
	public List<Ticket> getAllTicketsByTheaterId(int id) {
		return ticketdao.getAllTicketsByTheaterId(id);
	}

	@Override
	public Ticket getTicketInformation(int id) {
		return ticketdao.getTicketInformation(id);
	}

}

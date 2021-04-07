package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.pojo.Ticket;

@Service
public interface TicketHandlerService {

	public Ticket createTicket(Ticket ticket);
	
	public void deleteTicket(int id);
	
	public Ticket getTicketbyId(int id);
	
	public List<Ticket> getAllTickets();
	
	public List<Ticket> getAllTicketsByUser(int id);
	
	public List<Ticket> getAllTicketsByMovie(int id);
	
	public List<Ticket> getAllTicketsByScreen(int id);
	
	public List<Ticket> getAllTicketsBySeat(int id);
	
	public List<Ticket> getAllTicketsByTheaterId(int id);
	
	public Ticket getTicketInformation(int id);
	
}

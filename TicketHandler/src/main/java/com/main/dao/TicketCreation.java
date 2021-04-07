package com.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.main.pojo.Ticket;

@Repository
public interface TicketCreation {

	public Ticket createTicket(Ticket ticket);
	
	public void deleteTicket(int id);
	
	public Ticket getTicketById(int id);
	
	public List<Ticket> getAllTickets();
	
	public List<Ticket> getAllTicketsForMovieId(int id);
	
	public List<Ticket> getAllTicketForScreenId(int id);
	
	public List<Ticket> getAllTicketsByTheaterId(int id);
	
	public List<Ticket> getAllTicketsForSeatId(int id);
	
	public List<Ticket> getAllTicketsForUserId(int id);
	
	public Ticket getTicketInformation(int id);
	
}

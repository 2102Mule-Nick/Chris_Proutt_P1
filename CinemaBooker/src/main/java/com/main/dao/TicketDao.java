package com.main.dao;

import java.util.List;

import com.main.pojo.Ticket;
import com.main.pojo.User;

public interface TicketDao {

	public void createTicket(Ticket ticket);
	
	public void deleteTicket(Ticket ticket);
	
	public Ticket getTicketForUser(User user);
	
	public List<Ticket> getAllTicketsFromUser(User user);
}

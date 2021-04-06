package com.main.service;

import com.main.pojo.Ticket;

public interface TicketService {

	public void buyTicket(Ticket ticket, int quantity);
	
	public void deleteTicket(Ticket ticket);
	
}

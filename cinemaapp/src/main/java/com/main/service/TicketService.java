package com.main.service;

import com.main.pojo.Ticket;
import com.main.pojo.User;

public interface TicketService {

	public void buyTicket(Ticket ticket, int quantity);
	
	public void deleteTicket(int ticketId, User user);
	
}

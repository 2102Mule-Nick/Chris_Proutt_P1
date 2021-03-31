package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.TicketDao;
import com.main.messaging.JmsMessageSender;
import com.main.pojo.Movie;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;
import com.main.pojo.User;

@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketDao ticketdao;
	
	private JmsMessageSender messageSender;

	public TicketDao getTicketdao() {
		return ticketdao;
	}

	@Autowired
	public void setTicketdao(TicketDao ticketdao) {
		this.ticketdao = ticketdao;
	}

	@Autowired
	public void setMessageSender(JmsMessageSender messageSender) {
		this.messageSender = messageSender;
	}

	@Override
	public void buyTicket(Ticket ticket, int quantity) {
		
		messageSender.sendToInventoryQueue(ticket, quantity);
		
		ticketdao.createTicket(ticket);
		
	}

	@Override
	public void deleteTicket(int ticketId, User user) {
		// TODO Auto-generated method stub

	}

}

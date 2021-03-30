package com.main.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.pojo.Ticket;

@Component
public class TicketInventory implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8612996743698839615L;

	private Ticket ticket;
	
	private int quantity;

	public Ticket getTicket() {
		return ticket;
	}

	@Autowired
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getQuantity() {
		return quantity;
	}

	@Autowired
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TicketInventory(Ticket ticket, int quantity) {
		super();
		this.ticket = ticket;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "TicketInventory [ticket=" + ticket + ", quantity=" + quantity + "]";
	}
	
}

package com.main.dto;

import java.io.Serializable;

import com.main.pojo.Ticket;

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

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getQuantity() {
		return quantity;
	}

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

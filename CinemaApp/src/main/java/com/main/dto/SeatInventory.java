package com.main.dto;

import java.io.Serializable;

import com.main.pojo.Seat;

public class SeatInventory implements Serializable {

	public SeatInventory() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Seat seat;
	
	private int quantity;

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SeatInventory(Seat seat, int quantity) {
		super();
		this.seat = seat;
		this.quantity = quantity;
	}

}

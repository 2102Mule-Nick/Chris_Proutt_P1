package com.main.dao;

import java.util.List;

import com.main.pojo.Seat;

public interface SeatDao {

	public Seat createSeat(Seat seat);
	
	public void deleteSeat(int id);
	
	public Seat getSeatBySeatId(int id);
	
	public void makeSeatAvailable(int id);
	
	public void makeSeatUnavailable(int id);
	
	public void makeSeatAccessible(int id);
	
	public List<Seat> getAllSeat();
	
	public List<Seat> getAllSeatsInTheater(int id);

	public List<Seat> getAllSeatsInScreen(int id);
}

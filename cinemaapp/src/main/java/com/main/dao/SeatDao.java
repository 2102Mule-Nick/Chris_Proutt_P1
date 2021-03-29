package com.main.dao;

import java.util.List;

import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Theater;

public interface SeatDao {

	public void createSeat(Seat seat);
	
	public void deleteSeat(Seat seat);
	
	public Seat getSeatBySeatId(int id);
	
	public List<Seat> getAllSeatsInTheater(Theater theater);

	public List<Seat> getAllSeatsInScreen(Screen screen);
}

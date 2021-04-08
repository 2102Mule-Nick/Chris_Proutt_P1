package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.exceptions.InvalidSeatCapacity;
import com.main.exceptions.NoSeatsExist;
import com.main.exceptions.SeatDoesNotExist;
import com.main.exceptions.SeatNotAvailable;
import com.main.exceptions.seatNotAccesible;
import com.main.pojo.Seat;

@Service
public interface SeatService {

	public boolean isExistingSeat(int seatId) throws SeatDoesNotExist;
	
	public boolean isSeatAvailable(int seatId) throws SeatNotAvailable;
	
	public boolean isSeatAccesible(int seatId) throws seatNotAccesible;
	
	public Seat addSeat(Seat seat);
	
	public String removeSeat(int seatId);
	
	public String setSeatAvailable(int seatId) throws SeatNotAvailable;
	
	public Seat retrieveSeatById(int seatId) throws SeatDoesNotExist;
	
	public List<Seat> getAllSeats() throws NoSeatsExist;
	
	public List<Seat> getAllSeatsInScreen(int screenId) throws NoSeatsExist;
	
	public List<Seat> getAllSeatsInTheater(int theaterId) throws NoSeatsExist;
	
	public List<Seat> addSeatsForScreen(int ScreenId, int capacity) throws InvalidSeatCapacity;
}

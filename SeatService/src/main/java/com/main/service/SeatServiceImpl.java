package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.SeatDao;
import com.main.exceptions.InvalidSeatCapacity;
import com.main.exceptions.NoSeatsExist;
import com.main.exceptions.SeatDoesNotExist;
import com.main.exceptions.SeatNotAvailable;
import com.main.exceptions.seatNotAccesible;
import com.main.pojo.Seat;

@Service
public class SeatServiceImpl implements SeatService {
	
	private SeatDao seatdao;

	public SeatDao getSeatdao() {
		return seatdao;
	}

	@Autowired
	public void setSeatdao(SeatDao seatdao) {
		this.seatdao = seatdao;
	}

	@Override
	public boolean isExistingSeat(int seatId) throws SeatDoesNotExist {
		if(seatdao.getSeatBySeatId(seatId) != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isSeatAvailable(int seatId) throws SeatNotAvailable {
		try {
			if(this.isExistingSeat(seatId)) {
				Seat seat = seatdao.getSeatBySeatId(seatId);
				
				if(seat.isAvailable()) {
					return true;
				} else {		 
					throw new SeatNotAvailable();
				}
			}
		} catch (SeatDoesNotExist e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isSeatAccesible(int seatId) throws seatNotAccesible {
		try {
			if(this.isExistingSeat(seatId)) {
				Seat seat = seatdao.getSeatBySeatId(seatId);
				if(seat.isAccessible()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SeatDoesNotExist e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	@Transactional
	public Seat addSeat(Seat seat) {
		try {
			if(!this.isExistingSeat(seat.getSeat_id())) {
				seatdao.createSeat(seat);
				return seat;
			}
		} catch (SeatDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String removeSeat(int seatId) {
		try {
			if(this.isExistingSeat(seatId)) {
				seatdao.deleteSeat(seatId);
				return "Seat Successfully Removed";
			}
		} catch (SeatDoesNotExist e) {
			e.printStackTrace();
		}
		
		return "Seat Removal Unsucessfull";
	}

	@Override
	public String setSeatAvailable(int seatId){		
		try {
			if(!this.isSeatAvailable(seatId)) {
				seatdao.makeSeatAvailable(seatId);
				return "Seat Is Available";
			}
		} catch (SeatNotAvailable e) {
			e.printStackTrace();
		}
		
		return "Cannot seat to available";
	}

	@Override
	public Seat retrieveSeatById(int seatId){
		try {
			if(this.isExistingSeat(seatId)) {
				Seat seat = seatdao.getSeatBySeatId(seatId);
				return seat;
			}
		} catch (SeatDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Seat> getAllSeats() throws NoSeatsExist {
		List<Seat> seatList = seatdao.getAllSeat();
		
		if(seatList.size() > 0) {
			return seatList;
		} else {
			throw new NoSeatsExist();
		}
	}

	@Override
	public List<Seat> getAllSeatsInScreen(int screenId) throws NoSeatsExist {
		List<Seat> seatList = seatdao.getAllSeatsInScreen(screenId);
		
		if(seatList.size() > 0) {
			return seatList;
		} else {
			throw new NoSeatsExist();
		}
	}

	@Override
	public List<Seat> getAllSeatsInTheater(int theaterId) throws NoSeatsExist {
		List<Seat> seatList = seatdao.getAllSeatsInTheater(theaterId);
		
		if(seatList.size() > 0) {
			return seatList;
		} else {
			throw new NoSeatsExist();
		}
	}

	@Override
	public List<Seat> addSeatsForScreen(int screenId, int capacity) throws InvalidSeatCapacity {
		List<Seat> seatList = null;
		
		if(capacity > 0) {
			for(int i = 0; i < capacity; i++) {
				Seat seat = new Seat();
				seat.setScreen_id(screenId);
				seat.setSeat_number(i + "A");
				Seat newSeat = seatdao.createSeat(seat);
				seatList.add(newSeat);
			}
			
			return seatList;
		} else {
			throw new InvalidSeatCapacity();
		}
		
	}


}

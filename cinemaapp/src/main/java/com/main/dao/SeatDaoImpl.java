package com.main.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.SeatRowMapper;
import com.main.pojo.Seat;
import com.main.pojo.Theater;

@Repository
public class SeatDaoImpl implements SeatDao {

	private JdbcTemplate template;
	
	private SeatRowMapper mapper;
	
	@Override
	public void createSeat(Seat seat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSeat(Seat seat) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seat getSeatBySeatId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> getAllSeatsInTheater(Theater theater) {
		// TODO Auto-generated method stub
		return null;
	}

}

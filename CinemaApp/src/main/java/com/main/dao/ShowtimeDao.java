package com.main.dao;

import java.util.List;

import com.main.pojo.Showtime;

public interface ShowtimeDao {

	public Showtime createShowtime(Showtime showtime);
	
	public void deleteShowtime(int showtimeid);
	
	public Showtime getShowtimeByShowTimeId(int id);
	
	public List<Showtime> getAllShowTimesAtAtheater(int id);
	
	public List<Showtime> getAllShowTimeByMovie(int id);
	
}

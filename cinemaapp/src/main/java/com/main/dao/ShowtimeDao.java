package com.main.dao;

import java.util.List;

import com.main.pojo.Movie;
import com.main.pojo.Showtime;
import com.main.pojo.Theater;

public interface ShowtimeDao {

	public void createShowtime(Showtime showtime);
	
	public void deleteShowtime(Showtime showtime);
	
	public Showtime getShowtimeByShowTimeId(int id);
	
	public List<Showtime> getAllShowTimesAtAtheater(Theater theater);
	
	public List<Showtime> getAllShowTimeByMovie(Movie movie);
	
}

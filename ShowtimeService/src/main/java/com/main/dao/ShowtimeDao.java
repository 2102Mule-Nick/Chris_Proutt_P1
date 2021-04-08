package com.main.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.main.pojo.Showtime;

@Repository
public interface ShowtimeDao {
	//Create
	public Showtime createShowtime(Showtime showtime);
	
	//Reads
	public List<Showtime> getAllShowtimes();
	
	public List<Showtime> getAllShowTimesByTheater(int theaterid);
	
	public List<Showtime> getAllShowTimeByMovie(int movieId);
	
	public List<Showtime> getAllShowtimesByScreen(int screenId);
		
	public List<Showtime> getShowtimeByTime(Time time);
	
	public List<Showtime> getShowtimeByDate(Date date);
	
	public Showtime getShowtimeByShowTimeId(int id);
	
	//Updates
	public void updateShowingTime(int showtimeId, Time time);
	
	public void updateShowingDate(int showtimeId, Date date);
	
	//Delete
	public void deleteShowtime(int showtimeid);
		
	public void deleteAllShowtimes();
		
	public void deleteAllTimesByDate(Date date);
	
}

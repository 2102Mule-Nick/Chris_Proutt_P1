package com.main.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.main.exception.ShowtimeNotFound;
import com.main.pojo.Showtime;

@WebService
public interface ShowTimeCreator {
	
	@WebMethod
	public Showtime findShowtimeByShowtimeId(int showtimeId) throws ShowtimeNotFound;
	
	@WebMethod
	public List<Showtime> findShowtimeByMovieId(int movieId) throws ShowtimeNotFound;
	
	@WebMethod
	public Showtime createShowtime(Showtime showtime);
}

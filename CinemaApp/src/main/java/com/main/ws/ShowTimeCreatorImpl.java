package com.main.ws;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.ShowtimeDao;
import com.main.exception.ShowtimeNotFound;
import com.main.pojo.Showtime;

@Service
public class ShowTimeCreatorImpl implements ShowTimeCreator {

	@Autowired
	Logger log;
	
	private ShowtimeDao showtimedao;

	public ShowtimeDao getShowtimedao() {
		return showtimedao;
	}

	@Autowired
	public void setShowtimedao(ShowtimeDao showtimedao) {
		this.showtimedao = showtimedao;
	}

	@Override
	public Showtime findShowtimeByShowtimeId(int showtimeId) throws ShowtimeNotFound {
		log.info("Finding showtime with id of " + showtimeId);
		
		Showtime showtime = showtimedao.getShowtimeByShowTimeId(showtimeId);
		
		if(showtime == null) {
			throw new ShowtimeNotFound();
		}
		
		return showtime;
	}

	@Override
	public List<Showtime> findShowtimeByMovieId(int movieId) throws ShowtimeNotFound {
		
		log.info("Handlind finding showtimes for movie with the id: " + movieId);
		
		List<Showtime> showtimeList = showtimedao.getAllShowTimeByMovie(movieId);
		
		if(showtimeList.size() == 0) {
			throw new ShowtimeNotFound();
		}
		
		return showtimeList;
	}

	@Override
	public Showtime createShowtime(Showtime showtime) {
		log.info("Creating new showtime");
		
		return showtimedao.createShowtime(showtime);
	}

}

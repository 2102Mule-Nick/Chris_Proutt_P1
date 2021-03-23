package com.main.pojo;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ticket {
	
	private String movieTitle;
	
	private Time runtime;
	
	private String theater;
	
	private String address;
	
	private String showtime;
	
	private String seat;
	
	private String type;
	
	private String screen;

	public String getMovieTitle() {
		return movieTitle;
	}
	
	@Autowired
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Time getRuntime() {
		return runtime;
	}

	@Autowired
	public void setRuntime(Time runtime) {
		this.runtime = runtime;
	}

	public String getTheater() {
		return theater;
	}

	@Autowired
	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getAddress() {
		return address;
	}

	@Autowired
	public void setAddress(String address) {
		this.address = address;
	}

	public String getShowtime() {
		return showtime;
	}

	@Autowired
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getSeat() {
		return seat;
	}

	@Autowired
	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getType() {
		return type;
	}

	@Autowired
	public void setType(String type) {
		this.type = type;
	}

	public String getScreen() {
		return screen;
	}

	@Autowired
	public void setScreen(String screen) {
		this.screen = screen;
	}
}

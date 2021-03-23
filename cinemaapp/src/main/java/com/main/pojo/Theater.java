package com.main.pojo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Theater {
	
	private String theaterName;
	
	private String address;
	
	private List<Movie> showtimes;
	
	private List<Screen> screens;

	public String getTheaterName() {
		return theaterName;
	}

	@Autowired
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getAddress() {
		return address;
	}

	@Autowired
	public void setAddress(String address) {
		this.address = address;
	}

	public List<Movie> getShowtimes() {
		return showtimes;
	}

	@Autowired
	public void setShowtimes(List<Movie> showtimes) {
		this.showtimes = showtimes;
	}
}

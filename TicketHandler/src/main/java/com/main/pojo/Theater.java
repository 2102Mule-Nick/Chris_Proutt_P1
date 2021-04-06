package com.main.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Theater {
	
	public Theater() {
		super();
	}

	private int theater_id;
	
	private String theaterName;
	
	private String address;
	
	private int num_of_screens;
	
	private List<Movie> showtimes;
	
	private List<Screen> screens;

	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNum_of_screens() {
		return num_of_screens;
	}

	public void setNum_of_screens(int num_of_screens) {
		this.num_of_screens = num_of_screens;
	}

	public List<Movie> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Movie> showtimes) {
		this.showtimes = showtimes;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
}

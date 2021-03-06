package com.main.pojo;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class Showtime {
		
	private int showtime_id;
	
	private int theater_id;
	
	private int screen_id;
	
	private int movie_id;
	
	private Time showing_time;
	
	private Date showing_date;

	public int getShowtime_id() {
		return showtime_id;
	}
	
	public void setShowtime_id(int showtime_id) {
		this.showtime_id = showtime_id;
	}

	public int getTheater_id() {
		return theater_id;
	}
	
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public int getScreen_id() {
		return screen_id;
	}

	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public Time getShowing_time() {
		return showing_time;
	}

	public void setShowing_time(Time showing_time) {
		this.showing_time = showing_time;
	}

	public Date getShowing_date() {
		return showing_date;
	}

	public void setShowing_date(Date showing_date) {
		this.showing_date = showing_date;
	}
}
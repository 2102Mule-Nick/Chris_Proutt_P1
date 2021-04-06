package com.main.pojo;

import java.sql.Time;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Ticket {
	
	public Ticket() {
		super();
	}

	private int ticket_id;
	
	private int user_id;
	
	private String user_first_name;
	
	private String user_last_name;
	
	private int theater_id;
	
	private String theater_name;
	
	private String theater_address;
	
	private int movie_id;
	
	private String title;
	
	private Time runtime;
	
	private Date date;
	
	private Time showtime;
	
	private int seat_id;
	
	private String seat_number;
	
	private int screen_id;
	
	private String screen_name;

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public int getScreen_id() {
		return screen_id;
	}

	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public String getTheater_address() {
		return theater_address;
	}

	public void setTheater_address(String theater_address) {
		this.theater_address = theater_address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getRuntime() {
		return runtime;
	}

	public void setRuntime(Time runtime) {
		this.runtime = runtime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getShowtime() {
		return showtime;
	}

	public void setShowtime(Time showtime) {
		this.showtime = showtime;
	}

	public String getSeat_number() {
		return seat_number;
	}
	
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

}
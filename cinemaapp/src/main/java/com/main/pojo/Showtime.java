package com.main.pojo;

import java.sql.Time;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Showtime {
	
	private Date date;
	
	private Time time;
	
	private String type;
	
	private Theater theater;

	public Date getDate() {
		return date;
	}

	@Autowired
	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	@Autowired
	public void setTime(Time time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	@Autowired
	public void setType(String type) {
		this.type = type;
	}

	public Theater getTheater() {
		return theater;
	}

	@Autowired
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
}

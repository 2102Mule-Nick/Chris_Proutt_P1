package com.main.pojo;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Movie {

	private int movie_id;
	
	private String title;
	
	private String genre;
	
	private Time runTime;

	public int getMovie_id() {
		return movie_id;
	}

	@Autowired
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	@Autowired
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@Autowired
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Time getRunTime() {
		return runTime;
	}

	@Autowired
	public void setRunTime(Time runTime) {
		this.runTime = runTime;
	}
}

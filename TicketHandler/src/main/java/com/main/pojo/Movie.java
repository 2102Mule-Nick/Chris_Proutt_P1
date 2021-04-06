package com.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class Movie {

	private int movie_id;
	
	private String title;
	
	private String genre;
	
	private String runTime;

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	
	public Movie() {
		super();
	}
}

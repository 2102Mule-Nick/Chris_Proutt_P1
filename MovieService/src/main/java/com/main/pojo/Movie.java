package com.main.pojo;

import java.sql.Time;
import org.springframework.stereotype.Component;

@Component
public class Movie {

	private int movie_id;
	
	private String title;
	
	private String director;
	
	private String genre;
	
	private Time runTime;
	
	private String MPArating;
	
	private String synopsis;
		
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Time getRunTime() {
		return runTime;
	}

	public void setRunTime(Time runTime) {
		this.runTime = runTime;
	}

	public String getMPArating() {
		return MPArating;
	}

	public void setMPArating(String mPArating) {
		MPArating = mPArating;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

}

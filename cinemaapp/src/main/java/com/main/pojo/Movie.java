package com.main.pojo;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private List<Actor> cast;
	
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

	public String getDirector() {
		return director;
	}

	@Autowired
	public void setDirector(String director) {
		this.director = director;
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

	public String getMPArating() {
		return MPArating;
	}

	@Autowired
	public void setMPArating(String mPArating) {
		MPArating = mPArating;
	}

	public String getSynopsis() {
		return synopsis;
	}

	@Autowired
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public List<Actor> getCast() {
		return cast;
	}
	
	@Autowired
	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	
}

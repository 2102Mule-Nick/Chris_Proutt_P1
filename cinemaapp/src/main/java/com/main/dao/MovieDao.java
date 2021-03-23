package com.main.dao;

import com.main.pojo.Movie;

public interface MovieDao {
	
	public void addMovie(Movie movie);
	
	public void removeMovie(Movie movie);
	
	public Movie getMovieByTitle(String title, String director);
	
	public Movie getMovieByMovieId(int id);
	
	public void setCastList(Movie movie);
		
}

package com.main.dao;

import java.util.List;

import com.main.pojo.Movie;
import com.main.pojo.Theater;

public interface MovieDao {
	
	public void addMovie(Movie movie);
	
	public void removeMovie(Movie movie);
	
	public Movie getMovieByTitle(String title, String director);
	
	public Movie getMovieByMovieId(int id);
	
	public void setCastList(Movie movie);
	
	public List<Movie> getAllMoviesFromTheater(Theater theater);
		
}

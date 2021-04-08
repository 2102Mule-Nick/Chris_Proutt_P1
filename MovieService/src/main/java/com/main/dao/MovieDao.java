package com.main.dao;

import java.util.List;

import com.main.pojo.Movie;

public interface MovieDao {
	
	public Movie addMovie(Movie movie);
	
	public void removeMovie(int id);
	
	public Movie getMovieByMovieId(int id);
	
	public Movie getMovieByTitle(String title);
		
	public List<Movie> getAllMoviesFromTheater(int theaterId);
		
}

package com.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.main.pojo.Movie;

@Repository
public interface MovieDao {
	
	public Movie addMovie(Movie movie);
	
	public void removeMovie(int id);
	
	public Movie getMovieByMovieId(int id);
	
	public Movie getMovieByTitle(String title);
	
	public List<Movie> getAllMovies();
		
	public List<Movie> getAllMoviesFromTheater(int theaterId);
		
}

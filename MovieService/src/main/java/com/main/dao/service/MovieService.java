package com.main.dao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.exceptions.MovieAlreadyExists;
import com.main.exceptions.MovieDoesNotExist;
import com.main.exceptions.NoMoviesExist;
import com.main.pojo.Movie;

@Service
public interface MovieService {

	public boolean isExistingMovie(int movidId) throws MovieDoesNotExist;
	
	public boolean isExistingMovie(String title) throws MovieDoesNotExist;
	
	public Movie addMovie(Movie movie) throws MovieAlreadyExists;
	
	public String removeMovie(int movieId);
	
	public Movie getMovieByMovieId(int movieId);
	
	public Movie getMovieByMovieName(String string);
	
	public List<Movie> getAllMovies() throws NoMoviesExist;
	
	public List<Movie> getAllMoviesForTheater(int theaterId) throws NoMoviesExist;
}

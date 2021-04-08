package com.main.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.pojo.Movie;

@Service
public class MovieServiceFinder {
	
	public Movie createMovie(Movie movie) {
		RestTemplate template = new RestTemplate();
		
		return template.postForObject("http://localhost:8080/MovieService/movie/", template, Movie.class);
	}
	
	public String deleteTicket(int movieId) {
		RestTemplate template = new RestTemplate();
		
		template.delete("http://localhost:8080/MovieService/movie/" + movieId);
		return "Movie deleted successfully";
	}
	
	public Movie getMovieById(int movieid) {
		RestTemplate template = new RestTemplate();
		
		return template.getForObject("http://localhost:8080/MovieService/movie/" + movieid, Movie.class);
	}
	
	public List<Movie> getAllMovies(){
		RestTemplate template = new RestTemplate();
		
		Movie[] movieArray = template.getForObject("http://localhost:8080/MovieService/movie/", Movie[].class);
		
		List<Movie> movieList = Arrays.asList(movieArray);
		
		return movieList;
	}
	
	public List<Movie> getAllMoviesByTheaterId(int theaterId){
		RestTemplate template = new RestTemplate();
		
		Movie[] movieArray = template.getForObject("http://localhost:8080/MovieService/movie/theater/" + theaterId, Movie[].class);
		
		List<Movie> movieList = Arrays.asList(movieArray);
		
		return movieList;
	}
}

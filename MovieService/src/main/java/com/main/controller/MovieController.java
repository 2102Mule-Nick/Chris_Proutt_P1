package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.service.MovieService;
import com.main.exceptions.MovieDoesNotExist;
import com.main.exceptions.NoMoviesExist;
import com.main.pojo.Movie;

@RestController
public class MovieController {

	private MovieService service;

	public MovieService getService() {
		return service;
	}

	@Autowired
	public void setService(MovieService service) {
		this.service = service;
	}
	
	//Gets 
	@GetMapping("/movie")
	public List<Movie> getallMovies(){
		try {
			return service.getAllMovies();
		} catch (NoMoviesExist e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/movie/theater/{theaterId}")
	public List<Movie> getAllMoviesByTheater(@PathVariable int movieid){
		try {
			return service.getAllMoviesForTheater(movieid);
		} catch (NoMoviesExist e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/movie/{movieid}")
	public Movie getMovieByMovieId(@PathVariable int movieId) {
		return service.getMovieByMovieId(movieId);
	}
	
	@GetMapping("/movie/{movieTitle}")
	public Movie getMovieByMovieTitle(@PathVariable String movieTitle) {
		return service.getMovieByMovieName(movieTitle);
	}
	
	// Posts
	@PostMapping("/movie")
	public ResponseEntity<String> createMovie(@RequestBody Movie movie){
		try {
			if(service.isExistingMovie(movie.getMovie_id())) {
				return ResponseEntity.badRequest().body("Movie already exists."); 
			}
		} catch (MovieDoesNotExist e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok("Movie successfully inserted!");
	}
	
	// Delete
	@DeleteMapping("/movie/{movieId}")
	public String deleteMovie(@RequestBody int id) {
		return service.removeMovie(id);
	}
	
	// Updates
}

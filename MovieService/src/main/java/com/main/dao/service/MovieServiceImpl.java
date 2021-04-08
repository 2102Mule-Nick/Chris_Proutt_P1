package com.main.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.MovieDao;
import com.main.exceptions.MovieAlreadyExists;
import com.main.exceptions.MovieDoesNotExist;
import com.main.exceptions.NoMoviesExist;
import com.main.pojo.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieDao moviedao;
	
	@Autowired
	public void setMoviedao(MovieDao moviedao) {
		this.moviedao = moviedao;
	}

	@Override
	public boolean isExistingMovie(int movidId) throws MovieDoesNotExist {
		if(moviedao.getMovieByMovieId(movidId) != null) {
			return true;
		}else {
			throw new MovieDoesNotExist();
		}
	}

	@Override
	public boolean isExistingMovie(String title) throws MovieDoesNotExist {
		if(moviedao.getMovieByTitle(title) != null) {
			return true;
		}else {
			throw new MovieDoesNotExist();
		}
	}

	@Override
	public Movie addMovie(Movie movie) throws MovieAlreadyExists {
		try {
			if(!this.isExistingMovie(movie.getMovie_id())) {
				moviedao.addMovie(movie);
				return movie;
			}
		} catch (MovieDoesNotExist e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String removeSeat(int movieId) {
		try {
			if(this.isExistingMovie(movieId)) {
				moviedao.removeMovie(movieId);
				return "Screen Successfully removed";
			}
		} catch (MovieDoesNotExist e) {
			e.printStackTrace();
		}
		
		return "Movie Unsuccessfully Removed";
	}

	@Override
	public Movie getMovieByMovieId(int movieId) {
		try {
			if(this.isExistingMovie(movieId)) {
				return moviedao.getMovieByMovieId(movieId);
			}
		} catch (MovieDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Movie getScreenByMovieName(String string) {
		try {
			if(this.isExistingMovie(string)) {
				return moviedao.getMovieByTitle(string);
			}
		} catch (MovieDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Movie> getAllMovies() throws NoMoviesExist {
		List<Movie> movieList = moviedao.getAllMovies();
		
		if(movieList.size() > 0) {
			return movieList;
		} else {
			throw new NoMoviesExist();
		}
	}

	@Override
	public List<Movie> getAllMoviesForTheater(int theaterId) throws NoMoviesExist {
		List<Movie> movieList = moviedao.getAllMoviesFromTheater(theaterId);
		
		if(movieList.size() > 0) {
			return movieList;
		} else {
			throw new NoMoviesExist();
		}
	}

}

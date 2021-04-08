package com.main.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.MovieRowMapper;
import com.main.pojo.Movie;

@Repository
public class MovieDaoJDBCImpl implements MovieDao {

	private JdbcTemplate template;
	
	private MovieRowMapper mapper;
		
	@Override
	public Movie addMovie(Movie movie) {
		String sql = "insert into movies (title, director, genre, mparating, synopsis, runtime) values (?, ?, ?, ?, ?, ?)";

		template.update(sql, movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getMPArating(), movie.getSynopsis(), movie.getRunTime());
		return movie;
	}

	@Override
	public Movie getMovieByTitle(String title) {
		
		String sql = "select * from movies where title = ?";
		
		List<Movie> movieList = template.query(sql, mapper, title);
		
		return movieList.get(0);
	}

	@Override
	public Movie getMovieByMovieId(int id) {
		String sql = "select * from movies where movie_id = ?";
		
		List<Movie> movieList = template.query(sql, mapper, id);
		
		return movieList.get(0);
	}

	@Override
	public void removeMovie(int id) {
		String sql = "delete from movies where movie_id = ?";

		template.update(sql, id);		
	}

	@Override
	public List<Movie> getAllMoviesFromTheater(int theaterId) {
		String sql = "select * from showtimes where theater_id = ?";
		
		List<Movie> movieList = template.query(sql, mapper, theaterId);
		
		return movieList;
	}

}

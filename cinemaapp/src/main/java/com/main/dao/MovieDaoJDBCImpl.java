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
	
	private ActorDao actordao;
	
	@Override
	public void addMovie(Movie movie) {
		String sql = "insert into movies (title, director, genre, mparating, synopsis, runtime) values (?, ?, ?, ?, ?, ?)";

		template.update(sql, movie.getTitle(), movie.getDirector(), movie.getGenre(), movie.getMPArating(), movie.getSynopsis(), movie.getRunTime());
	}

	@Override
	public void removeMovie(Movie movie) {
		String sql = "delete from movies where movie_id = ?";

		template.update(sql, movie.getMovie_id());
	}

	@Override
	public Movie getMovieByTitle(String title, String director) {
		
		String sql = "select * from movies where title = ? and director = ?";
		
		List<Movie> movieList = template.query(sql, mapper, title, director);
		
		return movieList.get(0);
	}

	@Override
	public void setCastList(Movie movie) {
		movie.setCast(actordao.getActorsFromMovie(movie));
	}

	@Override
	public Movie getMovieByMovieId(int id) {
		String sql = "select * from movies where movie_id = ?";
		
		List<Movie> movieList = template.query(sql, mapper, id);
		
		return movieList.get(0);
	}

}

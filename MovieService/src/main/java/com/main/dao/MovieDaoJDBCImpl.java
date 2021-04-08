package com.main.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.MovieRowMapper;
import com.main.pojo.Movie;

@Repository
public class MovieDaoJDBCImpl implements MovieDao {

	private JdbcTemplate template;
	
	private MovieRowMapper mapper;
		
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setMapper(MovieRowMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Movie addMovie(Movie movie) {
		String sql = "insert into movies (title, director, genre, mparating, synopsis, runtime) values (?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		template.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getDirector());
			ps.setString(3, movie.getGenre());
			ps.setString(4, movie.getMPArating());
			ps.setString(5, movie.getSynopsis());
			ps.setTime(6, movie.getRunTime());
			return ps;
		}, keyHolder);
		
		movie.setMovie_id((int)keyHolder.getKeys().get("movie_id"));
		
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
		String sql = "select * from movies where theater_id = ?";
		
		List<Movie> movieList = template.query(sql, mapper, theaterId);
		
		return movieList;
	}

	@Override
	public List<Movie> getAllMovies() {
		String sql = "select * from movies";
		
		List<Movie> movieList = template.query(sql, mapper);
		
		return movieList;
	}

}

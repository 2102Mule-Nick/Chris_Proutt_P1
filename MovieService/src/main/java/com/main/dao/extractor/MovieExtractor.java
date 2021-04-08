package com.main.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.Movie;

@Component
public class MovieExtractor implements ResultSetExtractor<Movie> {

	@Override
	public Movie extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Movie movie = new Movie();
		
		movie.setMovie_id(rs.getInt("movie_id"));
		movie.setTitle(rs.getString("title"));
		movie.setDirector(rs.getString("director"));
		movie.setGenre(rs.getString("genre"));
		movie.setMPArating(rs.getString("mparating"));
		movie.setSynopsis(rs.getString("synopsis"));
		movie.setRunTime(rs.getTime("runtime"));
		
		return movie;
	}

}

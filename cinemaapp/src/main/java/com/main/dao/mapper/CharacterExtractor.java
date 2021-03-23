package com.main.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.main.pojo.MovieCharacter;

@Component
public class CharacterExtractor implements ResultSetExtractor<MovieCharacter> {

	@Override
	public MovieCharacter extractData(ResultSet rs) throws SQLException, DataAccessException {
		MovieCharacter character = new MovieCharacter();
		
		character.setCharacter_id(rs.getInt("character_id"));
		character.setActor_id(rs.getInt("actor_id"));
		character.setMovie_id(rs.getInt("movie_id"));
		character.setCharacter_name(rs.getString("character_name"));
		
		return character;
	}

}

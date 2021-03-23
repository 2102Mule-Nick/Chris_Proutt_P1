package com.main.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.mapper.CharacterRowMapper;
import com.main.pojo.Actor;
import com.main.pojo.Movie;
import com.main.pojo.MovieCharacter;

@Repository
public class CharacterDaoImpl implements CharacterDao {

	private JdbcTemplate template;
	
	private CharacterRowMapper mapper;
	
	@Override
	public void addCharacter(MovieCharacter character) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCharacter(MovieCharacter character) {
		// TODO Auto-generated method stub

	}

	@Override
	public MovieCharacter getCharacterByNameAndMovie(MovieCharacter character, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieCharacter> getAllCharactersByActor(Actor actor) {
		String sql = "select * from characters where actor_id = ?";
		List<MovieCharacter> characterList = template.query(sql, mapper, actor.getActor_id());
		
		return characterList;
	}

}

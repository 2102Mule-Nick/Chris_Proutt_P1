package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public CharacterRowMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(CharacterRowMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void addCharacter(MovieCharacter character) {
		String sql = "insert into characters (actor_id, character_name, movie_id) values (?, ?, ?)";
		
		template.update(sql, character.getActor_id(), character.getCharacter_name(), character.getMovie_id());
	}

	@Override
	public void deleteCharacter(MovieCharacter character) {
		String sql = "delete from characters where character_id = ?";
		
		template.update(sql, character.getCharacter_id());
	}

	@Override
	public MovieCharacter getCharacterByNameAndMovie(MovieCharacter character, Movie movie) {
		String sql = "select * from characters where character_id = ? and movie_id = ?";
		
		List<MovieCharacter> characterList = template.query(sql, mapper, character.getCharacter_id(), movie.getMovie_id());
		
		return characterList.get(0);
	}

	@Override
	public List<MovieCharacter> getAllCharactersByActor(Actor actor) {
		String sql = "select * from characters where actor_id = ?";
		List<MovieCharacter> characterList = template.query(sql, mapper, actor.getActor_id());
		
		return characterList;
	}

}

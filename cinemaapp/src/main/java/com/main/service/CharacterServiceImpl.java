package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.CharacterDao;
import com.main.pojo.Actor;
import com.main.pojo.Movie;
import com.main.pojo.MovieCharacter;

@Service
public class CharacterServiceImpl implements CharacterService {

	private CharacterDao characterdao;
	
	public CharacterDao getCharacterdao() {
		return characterdao;
	}

	@Autowired
	public void setCharacterdao(CharacterDao characterdao) {
		this.characterdao = characterdao;
	}

	@Override
	public MovieCharacter registerCharacter(MovieCharacter character) {
		
		characterdao.addCharacter(character);
		
		return character;
	}

	@Override
	public String removeCharacter(MovieCharacter character) {
		characterdao.deleteCharacter(character);
		
		return "Character removed";
	}

	@Override
	public MovieCharacter getCharacterByMovieandName(MovieCharacter character, Movie movie) {
		
		return characterdao.getCharacterByNameAndMovie(character, movie);
	}

	@Override
	public List<MovieCharacter> getAllCharactersPlayedByActor(Actor actor) {
		
		return characterdao.getAllCharactersByActor(actor);
	}

}

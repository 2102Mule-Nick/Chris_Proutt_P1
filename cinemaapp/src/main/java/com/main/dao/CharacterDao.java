package com.main.dao;

import java.util.List;

import com.main.pojo.Actor;
import com.main.pojo.Movie;
import com.main.pojo.MovieCharacter;

public interface CharacterDao {
	
	public void addCharacter(MovieCharacter character);
	
	public void deleteCharacter(MovieCharacter character);
	
	public MovieCharacter getCharacterByNameAndMovie(MovieCharacter character, Movie movie);
	
	public List<MovieCharacter> getAllCharactersByActor(Actor actor);
}

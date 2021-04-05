package com.main.service;

import java.util.List;

import com.main.pojo.Actor;
import com.main.pojo.Movie;
import com.main.pojo.MovieCharacter;

public interface CharacterService {
	
	public MovieCharacter registerCharacter(MovieCharacter character);
		
	public String removeCharacter(MovieCharacter character);
	
	public MovieCharacter getCharacterByMovieandName(MovieCharacter character, Movie movie);
	
	public List<MovieCharacter> getAllCharactersPlayedByActor(Actor actor);
}

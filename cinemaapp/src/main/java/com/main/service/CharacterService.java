package com.main.service;

import com.main.pojo.MovieCharacter;

public interface CharacterService {
	
	public MovieCharacter registerCharacter(MovieCharacter character);
	
	public void updateCharacter(MovieCharacter character);
	
	public boolean removeCharacter(MovieCharacter character);
	
}

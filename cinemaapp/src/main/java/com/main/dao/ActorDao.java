package com.main.dao;

import java.util.List;

import com.main.pojo.Actor;
import com.main.pojo.Movie;
import com.main.pojo.MovieCharacter;

public interface ActorDao {

	public void addActor(Actor actor);
	
	public void deleteActor(Actor actor);
	
	public List<Actor> getActorsFromMovie(Movie movie);
	
}

package com.main.dao;

import java.util.List;

import com.main.pojo.Actor;
import com.main.pojo.Movie;

public interface ActorDao {

	public void addActor(Actor actor);
	
	public void deleteActor(Actor actor);
	
	public List<Actor> getActorsFromMovie(int movieId);
	
}

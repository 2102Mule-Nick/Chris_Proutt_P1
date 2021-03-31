package com.main.service;

import com.main.pojo.Actor;

public interface ActorService {

	public boolean existingActor(Actor actor);
	
	public Actor registerActor(Actor actor);
	
	public void updateActor(Actor actor);
	
	public boolean removeActor(Actor actor);
	
}

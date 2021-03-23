package com.main.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Actor {
	
	private int actor_id;
	
	private String firstName;
	
	private String lastName;
	
	private String characterName;

	public int getActor_id() {
		return actor_id;
	}

	@Autowired
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getFirstName() {
		return firstName;
	}

	@Autowired
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Autowired
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCharacterName() {
		return characterName;
	}

	@Autowired
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
}

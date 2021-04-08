package com.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class Screen {

	private int screen_id;
	
	private int theater_id;
		
	private int capacity;
	
	private String screen_type;
	
	private String screen_name;

	public int getScreen_id() {
		return screen_id;
	}

	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}

	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getScreen_type() {
		return screen_type;
	}

	public void setScreen_type(String screen_type) {
		this.screen_type = screen_type;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
}

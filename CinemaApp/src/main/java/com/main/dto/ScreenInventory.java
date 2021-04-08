package com.main.dto;

import java.io.Serializable;

import com.main.pojo.Screen;

public class ScreenInventory implements Serializable {

	public ScreenInventory(Screen screen, int capacity) {
		super();
		this.setScreen(screen);
		this.capacity = capacity;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Screen screen;
	
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

}

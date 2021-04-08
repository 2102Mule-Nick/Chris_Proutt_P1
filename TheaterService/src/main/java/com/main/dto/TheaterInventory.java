package com.main.dto;

import java.io.Serializable;

import com.main.pojo.Theater;

public class TheaterInventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Theater theater;
	
	private int screens;

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public int getScreens() {
		return screens;
	}

	public void setScreens(int screens) {
		this.screens = screens;
	}

	public TheaterInventory(Theater theater, int screens) {
		super();
		this.theater = theater;
		this.screens = screens;
	}

}

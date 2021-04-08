package com.main.dao;

import java.util.List;

import com.main.pojo.Theater;

public interface TheaterDao {
	
	//Create
	public Theater createTheater(Theater theater);
	
	// Read
	public Theater getTheaterById(int id);
	
	public Theater getTheaterByName(String name);
	
	public List<Theater> getAllTheaters();
	
	// Update
	public void updateTheaterName(int theaterId, String name);
	
	public void updateTheaterAddress(int theaterId, String address);
	
	public void updateTheaterZipCode(int theaterId, String zipcode);
	
	public void updateNumberOfScreens(int theaterId, int screens);
	
	// Delete
	public void deleteTheater(int theaterid);
	
	public void deleteAllTheaters();
	
}

package com.main.dao;

import java.util.List;

import com.main.pojo.Theater;

public interface TheaterDao {

	public void createTheater(Theater theater);
	
	public void deleteTheater(Theater theater);
	
	public Theater getTheaterById(int id);
	
	public List<Theater> getAllTheaters();
}

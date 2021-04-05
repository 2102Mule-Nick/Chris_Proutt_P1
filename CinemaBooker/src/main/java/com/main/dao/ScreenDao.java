package com.main.dao;

import java.util.List;

import com.main.pojo.Screen;
import com.main.pojo.Theater;

public interface ScreenDao {

	public void createScreen(Screen screen);
	
	public void deleteScreen(Screen screen);
	
	public Screen getScreenById(int id);
	
	public List<Screen> getAllScreensAtTheater(Theater theater);
	
	public List<Screen> getAllScreens();
}

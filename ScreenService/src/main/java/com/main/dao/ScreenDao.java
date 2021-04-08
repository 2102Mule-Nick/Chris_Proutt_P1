package com.main.dao;

import java.util.List;

import com.main.pojo.Screen;

public interface ScreenDao {

	public Screen createScreen(Screen screen);
	
	public void deleteScreen(int id);
	
	public Screen getScreenById(int id);
	
	public Screen getScreenByName(String screenName);
	
	public Screen getScreenByTheaterIdandScreenName(int theaterId, String screenName);
	
	public void setScreenType(int id, String string);
	
	public List<Screen> getAllScreens();
	
	public List<Screen> getAllScreensAtTheater(int theaterId);
}

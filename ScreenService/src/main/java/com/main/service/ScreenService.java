package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.exceptions.InvalidNumberOfScreens;
import com.main.exceptions.NoScreensExist;
import com.main.exceptions.ScreenDoesNotExist;
import com.main.exceptions.SeatAlreadyExists;
import com.main.pojo.Screen;

@Service
public interface ScreenService {

	public boolean isExistingScreen(int id) throws ScreenDoesNotExist;
	
	public boolean isExistingScreen(String screenName) throws ScreenDoesNotExist;
	
	public Screen addScreen(Screen screen) throws SeatAlreadyExists;
	
	public String removeSeat(int screenId);
	
	public String setScreenType(int screenId, String string);
	
	public Screen getScreenByScreenId(int screenId);
	
	public Screen getScreenByTheaterIdandScreenName(int theaterId, String screenName);
	
	public List<Screen> getAllScreens() throws NoScreensExist; 
	
	public List<Screen> getAllScreensByTheater(int theaterId) throws NoScreensExist;
	
	public List<Screen> addScreensForTheater(int theaterId, int num_of_screens) throws InvalidNumberOfScreens;

}

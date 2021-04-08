package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.ScreenDao;
import com.main.exceptions.InvalidNumberOfScreens;
import com.main.exceptions.NoScreensExist;
import com.main.exceptions.ScreenDoesNotExist;
import com.main.exceptions.SeatAlreadyExists;
import com.main.messaging.SeatMessageSender;
import com.main.pojo.Screen;

@Service
public class ScreenServiceImpl implements ScreenService {

	private ScreenDao screendao;
	
	private SeatMessageSender sender;
	
	public ScreenDao getScreendao() {
		return screendao;
	}

	@Autowired
	public void setScreendao(ScreenDao screendao) {
		this.screendao = screendao;
	}

	public SeatMessageSender getSender() {
		return sender;
	}

	@Autowired
	public void setSender(SeatMessageSender sender) {
		this.sender = sender;
	}

	@Override
	public boolean isExistingScreen(int id) throws ScreenDoesNotExist {
		if(screendao.getScreenById(id) != null) {
			return true;
		} else {
			throw new ScreenDoesNotExist();
		}
	}

	@Override
	@Transactional
	public Screen addScreen(Screen screen) throws SeatAlreadyExists {
		
		sender.sendToSeatQueue(screen, screen.getCapacity());
		
		try {
			if(!this.isExistingScreen(screen.getScreen_id())) {
				screendao.createScreen(screen);
				return screen;
			}
		} catch (ScreenDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String removeSeat(int screenId) {
		try {
			if(this.isExistingScreen(screenId)) {
				screendao.deleteScreen(screenId);
				return "Screen Successfully Removed";
			}
		} catch (ScreenDoesNotExist e) {
			e.printStackTrace();
		}
		
		return "Screen Removal Unsucessful";
	}

	@Override
	public String setScreenType(int screenid, String string) {
		try {
			if(this.isExistingScreen(screenid)) {
				screendao.setScreenType(screenid, string);
				return "Screen Type Successfully";
			}
		} catch (ScreenDoesNotExist e) {
			e.printStackTrace();
		}
		
		return "Screen Type Could Not Be Set";
	}

	@Override
	public Screen getScreenByScreenId(int screenId) {
		try {
			if(this.isExistingScreen(screenId)) {
				return screendao.getScreenById(screenId);
			}
		} catch (ScreenDoesNotExist e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Screen> getAllScreens() throws NoScreensExist {
		List<Screen> screenList = screendao.getAllScreens();
		
		if(screenList.size() > 0) {
			return screenList;
		} else {
			throw new NoScreensExist();
		}
	}

	@Override
	public List<Screen> getAllScreensByTheater(int theaterId) throws NoScreensExist {
		List<Screen> screenList = screendao.getAllScreensAtTheater(theaterId);
		
		if(screenList.size() > 0) {
			return screenList;
		} else {
			throw new NoScreensExist();
		}
	}

	@Override
	public List<Screen> addScreensForTheater(int theaterId, int num_of_screens) throws InvalidNumberOfScreens {
		List<Screen> seatList = null;
		
		if(num_of_screens > 0) {
			for(int i = 0; i < num_of_screens; i++) {
				Screen screen = new Screen();
				screen.setTheater_id(theaterId);
				screen.setScreen_name("Screen " + i);
				Screen newScreen = screendao.createScreen(screen);
				seatList.add(newScreen);
			}
			
			return seatList;
		} else {
			throw new InvalidNumberOfScreens();
		}
	}

	@Override
	public Screen getScreenByTheaterIdandScreenName(int theaterId, String screenName) {
		try {
			if(this.isExistingScreen(screenName)) {
				return screendao.getScreenByTheaterIdandScreenName(theaterId, screenName);
			}
		} catch (ScreenDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean isExistingScreen(String screenName) throws ScreenDoesNotExist {
		
		if(screendao.getScreenByName(screenName) != null) {
			return true;
		} else {
			throw new ScreenDoesNotExist();
		}
	}

}

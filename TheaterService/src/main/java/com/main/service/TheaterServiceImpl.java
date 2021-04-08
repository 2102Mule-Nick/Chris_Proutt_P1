package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.TheaterDao;
import com.main.exceptions.NoTheatersExist;
import com.main.exceptions.TheaterDoesNotExist;
import com.main.exceptions.TheaterHasNoAddress;
import com.main.exceptions.TheaterHasNoName;
import com.main.exceptions.TheaterHasNoScreens;
import com.main.exceptions.TheaterHasNoZipcode;
import com.main.messaging.TheaterMessageSender;
import com.main.pojo.Theater;

@Service
public class TheaterServiceImpl implements TheaterService {

	private TheaterDao theaterdao;
	
	private TheaterMessageSender sender;
	
	public TheaterDao getTheaterdao() {
		return theaterdao;
	}

	@Autowired
	public void setTheaterdao(TheaterDao theaterdao) {
		this.theaterdao = theaterdao;
	}

	@Autowired
	public void setSender(TheaterMessageSender sender) {
		this.sender = sender;
	}

	@Override
	public boolean isExistingTheater(int theaterid) throws TheaterDoesNotExist {
		if(theaterdao.getTheaterById(theaterid) != null) {
			return true;
		} else {
			throw new TheaterDoesNotExist();
		}

	}
	
	@Override
	public boolean isExistingTheater(String name) throws TheaterDoesNotExist {
		if(theaterdao.getTheaterByName(name) != null) {
			return true;
		} else {
			throw new TheaterDoesNotExist();
		}

	}

	@Override
	public boolean hasName(int theaterid) throws TheaterHasNoName {
		if(theaterdao.getTheaterById(theaterid).getTheaterName() != null) {
			return true;
		} else {
			throw new TheaterHasNoName();
		}
	}

	@Override
	public boolean hasAddress(int theaterId) throws TheaterHasNoAddress {
		if(theaterdao.getTheaterById(theaterId).getAddress() != null) {
			return true;
		} else {
			throw new TheaterHasNoAddress();
		}
	}

	@Override
	public boolean hasZipCode(int theaterId) throws TheaterHasNoZipcode {
		if(theaterdao.getTheaterById(theaterId).getZipcode() != null) {
			return true;
		} else {
			throw new TheaterHasNoZipcode();
		}
	}

	@Override
	public boolean hasScreens(int theaterId) throws TheaterHasNoScreens {
		if(theaterdao.getTheaterById(theaterId).getNum_of_screens() > 0) {
			return true;
		} else {
			throw new TheaterHasNoScreens();
		}
	}

	@Override
	@Transactional
	public Theater addTheater(Theater theater) {
		sender.sendToTheaterQueue(theater, theater.getNum_of_screens());
		
		try {
			if(!this.isExistingTheater(theater.getTheater_id())) {
				return theaterdao.createTheater(theater);
			}
		} catch (TheaterDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String removeTheater(int theaterId) {
		try {
			if(this.isExistingTheater(theaterId)) {
				theaterdao.deleteTheater(theaterId);
				return "Theater Successfully Deleted";
			}
		} catch (TheaterDoesNotExist e) {
			e.printStackTrace();
		}
		
		return "Theater UnSuccesfully Deleted.";
	}

	@Override
	public String removeAllTheaters() throws NoTheatersExist {
		List<Theater> theaterList = theaterdao.getAllTheaters();
		
		if(theaterList.size() > 0) {
			theaterdao.deleteAllTheaters();
			return "All Theaters Successfully Deleted";
		} else {
			throw new NoTheatersExist();
		}
	}

	@Override
	public Theater getTheaterByTheater(int theaterId) {
		try {
			if(this.isExistingTheater(theaterId)) {
				return theaterdao.getTheaterById(theaterId);
			}
		} catch (TheaterDoesNotExist e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Theater getTheaterByTheaterName(String name) {
		try {
			if(this.isExistingTheater(name)) {
				return theaterdao.getTheaterByName(name);
			}
		} catch (TheaterDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Theater> getAllTheaters() throws NoTheatersExist {
		List<Theater> theaterList = theaterdao.getAllTheaters();
		
		if(theaterList.size() > 0) {
			return theaterList;
		} else {
			throw new NoTheatersExist();
		}
	}

	@Override
	public String setTheaterName(int theaterId, String name) {
		try {
			if(!this.hasName(theaterId) || !theaterdao.getTheaterById(theaterId).getTheaterName().equals(name)) {
				theaterdao.updateTheaterName(theaterId, name);
				return "Theater Name Successfully Updated";
			}
		} catch (TheaterHasNoName e) {
			e.printStackTrace();
		}
		
		return "Theater Name Update Unsuccessful";
	}

	@Override
	public String setTheaterAddress(int theaterId, String address) {
		try {
			if(!this.hasAddress(theaterId) || !theaterdao.getTheaterById(theaterId).getAddress().equals(address)) {
				theaterdao.updateTheaterAddress(theaterId, address);
				return "Theater Address Successfully Updated";
			}
		} catch (TheaterHasNoAddress e) {
			e.printStackTrace();
		}
		
		return "Theater Address Update Unsuccessful";
	}

	@Override
	public String setTheaterZip(int theaterId, String zipcode) {
		try {
			if(!this.hasZipCode(theaterId) || theaterdao.getTheaterById(theaterId).getZipcode().equals(zipcode)) {
				theaterdao.updateTheaterZipCode(theaterId, zipcode);
				return "Theater Zipcode Successfully Updated";
			}
		} catch (TheaterHasNoZipcode e) {
			e.printStackTrace();
		}
		
		return "Theater Zipcode Update Unsuccessful";
	}

	@Override
	public String setScreens(int theaterId, int screens) {
		try {
			if(!this.hasScreens(theaterId) || theaterdao.getTheaterById(theaterId).getNum_of_screens() == screens) {
				theaterdao.updateNumberOfScreens(theaterId, screens);
				return "Number of Screens Successfully Updated";
			}
		} catch (TheaterHasNoScreens e) {
			e.printStackTrace();
		} 
		
		return "Screen Update Unsuccessful";
	}

}

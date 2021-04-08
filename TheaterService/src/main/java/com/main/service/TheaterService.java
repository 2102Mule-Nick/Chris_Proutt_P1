package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.exceptions.NoTheatersExist;
import com.main.exceptions.TheaterDoesNotExist;
import com.main.exceptions.TheaterHasNoAddress;
import com.main.exceptions.TheaterHasNoName;
import com.main.exceptions.TheaterHasNoScreens;
import com.main.exceptions.TheaterHasNoZipcode;
import com.main.pojo.Theater;

@Service
public interface TheaterService {
	
	public boolean isExistingTheater(int theaterid) throws TheaterDoesNotExist;
	
	public boolean isExistingTheater(String name) throws TheaterDoesNotExist;
	
	public boolean hasName(int theaterid) throws TheaterHasNoName;
	
	public boolean hasAddress(int theaterId) throws TheaterHasNoAddress;
	
	public boolean hasZipCode(int theaterId) throws TheaterHasNoZipcode;
	
	public boolean hasScreens(int theaterId) throws TheaterHasNoScreens;
	
	public Theater addTheater(Theater theater);
	
	public String removeTheater(int theaterId);
	
	public String removeAllTheaters() throws NoTheatersExist;
	
	public Theater getTheaterByTheater(int theaterId);
	
	public Theater getTheaterByTheaterName(String name);
	
	public List<Theater> getAllTheaters() throws NoTheatersExist;
	
	public String setTheaterName(int theaterId, String name);
	
	public String setTheaterAddress(int theaterId, String address);
	
	public String setTheaterZip(int theaterId, String zipcode);
	
	public String setScreens(int theaterId, int screens);
}

package com.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class Theater {
	
	private int theater_id;
	
	private String theaterName;
	
	private String address;
	
	private String zipcode;
	
	private int num_of_screens;

	public int getTheater_id() {
		return theater_id;
	}

	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getNum_of_screens() {
		return num_of_screens;
	}

	public void setNum_of_screens(int num_of_screens) {
		this.num_of_screens = num_of_screens;
	}

}

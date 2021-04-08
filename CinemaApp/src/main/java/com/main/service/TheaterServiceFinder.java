package com.main.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.pojo.Theater;

@Service
public class TheaterServiceFinder {

	//Posts
	public Theater addTheater(Theater theater) {
		RestTemplate template = new RestTemplate();
		
		return template.postForObject("http://localhost:8080/TheaterService/theater", template, Theater.class);
	}
	
	//Gets
	public List<Theater> getAllTheaters(){
		RestTemplate template = new RestTemplate();
		
		Theater[] theaterArray = template.getForObject("http://localhost:8080/TheaterService/theater", Theater[].class);
		
		List<Theater> theaterList = Arrays.asList(theaterArray);
		
		return theaterList;
	}
	
	public Theater getTheaterById(int theaterId) {
		RestTemplate template = new RestTemplate();

		return template.getForObject("http://localhost:8080/TheaterService/theater/" + theaterId, Theater.class);
	}
	
	public Theater getTheaterByName(String name) {
		RestTemplate template = new RestTemplate();

		return template.getForObject("http://localhost:8080/TheaterService/theater/" + name, Theater.class);
	}
	
	
	//Puts
	public void updateTheaterName(int theaterId, String name) {
		RestTemplate template = new RestTemplate();
		template.put("http:localhost:8080/TheaterService/theater/" + theaterId + "/" + name, null);
	}
	
	public void updateTheaterAddress(int theaterId, String address) {
		RestTemplate template = new RestTemplate();
		template.put("http:localhost:8080/TheaterService/theater/" + theaterId + "/" + address, null);
	}
	
	public void updateTheaterZipcode(int theaterId, String zip) {
		RestTemplate template = new RestTemplate();
		template.put("http:localhost:8080/TheaterService/theater/" + theaterId + "/" + zip, null);
	}
	
	public void updateTheaterScreens(int theaterId, int screens) {
		RestTemplate template = new RestTemplate();
		template.put("http:localhost:8080/TheaterService/theater/" + theaterId + "/" + screens, null);
	}
	
	//Deletes
	public void deleteAllTheaters() {
		RestTemplate template = new RestTemplate();
		
		template.delete("http:localhost:8080/TheaterService/theater");
	}
	
	public void deleteTheaterByTheaterId(int theaterId) {
		RestTemplate template = new RestTemplate();

		template.delete("http:localhost:8080/TheaterService/theater/" + theaterId);
	}
}

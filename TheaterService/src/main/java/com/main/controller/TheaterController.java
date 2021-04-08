package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.exceptions.NoTheatersExist;
import com.main.pojo.Theater;
import com.main.service.TheaterService;

@RestController
public class TheaterController {

	private TheaterService service;

	@Autowired
	public void setService(TheaterService service) {
		this.service = service;
	}
	
	//Posts
	@PostMapping("/theater")
	public Theater addTheater(Theater theater) {
		return service.addTheater(theater);
	}
	
	//Gets
	@GetMapping("/theater")
	public List<Theater> getAllTheaters(){
		try {
			return service.getAllTheaters();
		} catch (NoTheatersExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/theater/{theaterid}")
	public Theater getTheaterById(@PathVariable int theaterId) {
		return service.getTheaterByTheater(theaterId);
	}
	
	@GetMapping("/theater/{theaterName}")
	public Theater getTheaterByName(@PathVariable String name) {
		return service.getTheaterByTheaterName(name);
	}
	
	//Update
	@PutMapping("/theater/{theaterid}/{theaterName}")
	public String updateTheaterName(@RequestBody int theaterId, String name) {
		return service.setTheaterName(theaterId, name);
	}
	
	@PutMapping("/theater/{theaterid}/{theaterAddress}")
	public String updateTheaterAddress(@RequestBody int theaterId, String address) {
		return service.setTheaterAddress(theaterId, address);
	}
	
	@PutMapping("/theater/{theaterId}/{theaterZip}")
	public String updateTheaterZipcode(@RequestBody int theater, String zip) {
		return service.setTheaterZip(theater, zip);
	}
	
	@PutMapping("/theater/{theaterId}/{theaterScreens}")
	public String updateNumberOfScreens(@RequestBody int theater, int screens) {
		return service.setScreens(theater, screens);
	} 
	
	//Deletes
	@DeleteMapping("/theater/{theaterId}")
	public String deleteTheaterById(@PathVariable int theaterId) {
		return service.removeTheater(theaterId);
	}
	
	@DeleteMapping("/theater")
	public String deleteAllTheaters() {
		try {
			return service.removeAllTheaters();
		} catch (NoTheatersExist e) {
			e.printStackTrace();
		}
		return null;
	}
}

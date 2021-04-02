package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.pojo.Movie;
import com.main.pojo.Ticket;
import com.main.pojo.User;
import com.main.service.TicketHandlerService;

@RestController
public class TicketController {

	private TicketHandlerService service;

	@Autowired
	public void setService(TicketHandlerService service) {
		this.service = service;
	}
	
	@PostMapping("/ticket")
	public String createTicket(@RequestBody Ticket ticket) {
		service.createTicket(ticket);
		return "New Ticket Created";
	}
	
	@DeleteMapping("/ticket/{ticketId}")
	public String deleteTicket(@RequestBody Ticket ticket) {
		service.deleteTicket(ticket);
		return "Ticket Deleted";
	}
	
	@GetMapping("/ticket/{ticketID}")
	public Ticket getTicketById(@PathVariable int id) {
		return service.getTicketbyId(id);
	}
	
	@GetMapping("/ticket")
	public List<Ticket> getAllTickets(){
		return service.getAllTickets();
	}
	
	@GetMapping("/ticket/user/{userId}")
	public List<Ticket> getAllTicketsByUser(@RequestBody User user){
		return service.getAllTicketsByUser(user);
	}
	
	@GetMapping("ticket/movie/{movieId}")
	public List<Ticket> getAllTicketsByMovie(@RequestBody Movie movie){
		return service.getAllTicketsByMovie(movie);
	}
		
}

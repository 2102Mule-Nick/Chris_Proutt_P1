package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.pojo.Ticket;
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
		return "New Tickets Created";
	}
	
	@DeleteMapping("/ticket/{ticketId}")
	public String deleteTicket(@PathVariable int ticketId) {
		service.deleteTicket(ticketId);
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
	public List<Ticket> getAllTicketsByUser(@PathVariable int userId){
		return service.getAllTicketsByUser(userId);
	}
	
	@GetMapping("/ticket/movie/{movieId}")
	public List<Ticket> getAllTicketsByMovie(@PathVariable int movieId){
		return service.getAllTicketsByMovie(movieId);
	}
	
	@GetMapping("/ticket/theater/{theaterId}")
	public List<Ticket> getAllTicketByTheater(@PathVariable Integer theaterid){
		return service.getAllTicketsByTheaterId(theaterid);
	}
	
	@GetMapping("/ticket/screen/{screenId}")
	public List<Ticket> getAllTicketsByScreen(@PathVariable int screenid){
		return service.getAllTicketsByScreen(screenid);
	}
	
	@GetMapping("/ticket/seat/{seatId}")
	public List<Ticket> getAllTicketsBySeat(@PathVariable int seatid){
		return service.getAllTicketsBySeat(seatid);
	}
	
	@GetMapping("/ticket/{ticketId}/info")
	public Ticket getTicketInformation(@PathVariable int ticketid) {
		return service.getTicketInformation(ticketid);
	}
		
}

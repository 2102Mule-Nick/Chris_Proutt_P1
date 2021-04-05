package com.main.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.pojo.Movie;
import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;
import com.main.pojo.User;

@Service
public class TicketServiceFinder {

	public Ticket createTicket(Ticket ticket) {
		
		RestTemplate template = new RestTemplate();
		
		return template.postForObject("http://localhost:8080/TicketHandler/ticket", ticket, Ticket.class);
	}
	
	public String deleteTicket(Ticket ticket) {
		RestTemplate template = new RestTemplate();
		
		template.delete("http://localhost:8080/TicketHandler/ticket/" + ticket.getTicket_id());
		return "Ticket deleted";
	}
	
	public Ticket getTicketByID(int id) {
		RestTemplate template = new RestTemplate();
		
		return template.getForObject("http://localhost:8080/TicketHandler/ticket/" + id, Ticket.class);
	}
	
	public List<Ticket> getAllTickets(){
		RestTemplate template = new RestTemplate();
		
		Ticket[] ticketArray = template.getForObject("http://localhost:8080/TicketHandler/ticket/", Ticket[].class);
		
		List<Ticket> ticketList = Arrays.asList(ticketArray);
		//ResponseEntity<List<Ticket>> response = template.exchange("http://localhost:8080/TicketHandler/ticket/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Ticket>>);
		
		return ticketList;
	}
	
	public List<Ticket> getAllTicketsByUser(User user){
		RestTemplate template = new RestTemplate();
		
		Ticket[] ticketArray = template.getForObject("http://localhost:8080/TicketHandler/ticket/user/" + user.getUser_id(), Ticket[].class);
		
		List<Ticket> ticketList = Arrays.asList(ticketArray);
		
		return ticketList;
	}
	
	public List<Ticket> getAllTicketsByMovie(Movie movie){
		RestTemplate template = new RestTemplate();
		
		Ticket[] ticketArray = template.getForObject("http://localhost:8080/TicketHandler/ticket/movie/" + movie.getMovie_id(), Ticket[].class);
		
		List<Ticket> ticketList = Arrays.asList(ticketArray);
		
		return ticketList;
	}
	
	public List<Ticket> getAllTicketsByTheater(Theater theater){
		RestTemplate template = new RestTemplate();
		
		Ticket[] ticketArray = template.getForObject("http://localhost:8080/TicketHandler/ticket/theater/" + theater.getTheater_id(), Ticket[].class);
		
		List<Ticket> ticketList = Arrays.asList(ticketArray);
		
		return ticketList;
	}
	
	public List<Ticket> getAllTicketsByScreen(Screen screen){
		RestTemplate template = new RestTemplate();
		
		Ticket[] ticketArray = template.getForObject("http://localhost:8080/TicketHandler/ticket/screen/" + screen.getScreen_id(), Ticket[].class);
		
		List<Ticket> ticketList = Arrays.asList(ticketArray);
		
		return ticketList;
	}
	
	public List<Ticket> getAllTicketsBySeat(Seat seat){
		RestTemplate template = new RestTemplate();
		
		Ticket[] ticketArray = template.getForObject("http://localhost:8080/TicketHandler/ticket/seat/" + seat.getSeat_id(), Ticket[].class);
		
		List<Ticket> ticketList = Arrays.asList(ticketArray);
		
		return ticketList;
	}
	
	public Ticket getTicketInformation(int id) {
		RestTemplate template = new RestTemplate();
		
		return template.getForObject("http://localhost:8080/TicketHandler/ticket/" + id + "/info", Ticket.class);
	}
}

package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.pojo.Movie;
import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;
import com.main.pojo.User;

@Service
public interface TicketHandlerService {

	public void createTicket(Ticket ticket);
	
	public void deleteTicket(Ticket ticket);
	
	public Ticket getTicketbyId(int id);
	
	public List<Ticket> getAllTickets();
	
	public List<Ticket> getAllTicketsByUser(User user);
	
	public List<Ticket> getAllTicketsByMovie(Movie movie);
	
	public List<Ticket> getAllTicketsByScreen(Screen screen);
	
	public List<Ticket> getAllTicketsBySeat(Seat seat);
	
	public List<Ticket> getAllTicketsByTheater(Theater theater);
	
	public Ticket getTicketInformation(int id);
	
}

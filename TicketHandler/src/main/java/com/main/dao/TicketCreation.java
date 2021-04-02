package com.main.dao;

import java.util.List;

import com.main.pojo.Movie;
import com.main.pojo.Screen;
import com.main.pojo.Seat;
import com.main.pojo.Showtime;
import com.main.pojo.Theater;
import com.main.pojo.Ticket;
import com.main.pojo.User;

public interface TicketCreation {

	public void createTicket(Ticket ticket);
	
	public void deleteTicket(Ticket ticket);
	
	public Ticket getTicketById(int id);
	
	public List<Ticket> getAllTickets();
	
	public List<Ticket> getAllTicketsForMovie(Movie movie);
	
	public List<Ticket> getAllTicketForScreen(Screen screen);
	
	public List<Ticket> getAllTicketForTheater(Theater theater);
	
	public List<Ticket> getAllTicketsForSeat(Seat seat);
	
	public List<Ticket> getAllTicketsForUser(User user);
	
	public Ticket getTicketInformation(int id);
	
}

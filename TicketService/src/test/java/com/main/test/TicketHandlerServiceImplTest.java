package com.main.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.main.dao.TicketCreation;
import com.main.dao.TicketCreationDaoImpl;
import com.main.pojo.Ticket;
import com.main.service.TicketHandlerService;
import com.main.service.TicketHandlerServiceImpl;

public class TicketHandlerServiceImplTest {

	private static Ticket ticket;
	
	private static TicketCreation ticketdao;
	
	private static TicketHandlerService service;
	
	@Before
	public void setUp() throws Exception {
		ticket = new Ticket(1, 1, 1, 1, 1);
		ticketdao = new TicketCreationDaoImpl();
		service = new TicketHandlerServiceImpl(ticketdao);
	}

	@After
	public void tearDown() throws Exception {
		ticket = null;
		ticketdao = null;
		service = null;
	}

	@Test
	public void testCreateTicket() {
		assertEquals("The ticket returned should match the ticket sent", service.createTicket(ticket), ticket);
	}

	@Test
	public void testDeleteTicket() {
		service.deleteTicket(ticket.getTicket_id());
		
		assertNull("The ticket should no longer exist", ticket);
	}

	@Test
	public void testGetTicketbyId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTickets() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTicketsByUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTicketsByMovie() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTicketsByScreen() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTicketsBySeat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTicketsByTheater() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTicketInformation() {
		fail("Not yet implemented");
	}

}

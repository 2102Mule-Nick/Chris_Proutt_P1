package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.main.dao.TicketDao;
import com.main.dao.TicketDaoJDBCImpl;
import com.main.pojo.Ticket;
import com.main.service.TicketService;
import com.main.service.TicketServiceImpl;

class TicketServiceImplTest {
	
	private static Ticket ticket;
	
	private static TicketDao ticketdao;
	
	private static TicketService service;

	@BeforeEach
	void setUp() throws Exception {
		ticket = new Ticket();
		ticketdao = new TicketDaoJDBCImpl();
		service = new TicketServiceImpl(ticketdao);
	}

	@AfterEach
	void tearDown() throws Exception {
		ticket = null;
		ticketdao = null;
		service = null;
	}

	@Test
	void testBuyTicket() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteTicket() {
		service.deleteTicket(ticket);
		assertNull(ticket);
	}

}

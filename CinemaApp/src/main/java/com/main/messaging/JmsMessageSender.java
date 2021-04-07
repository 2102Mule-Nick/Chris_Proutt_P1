package com.main.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.main.dto.SeatInventory;
import com.main.pojo.Seat;

@Service
public class JmsMessageSender {

	private JmsTemplate template; 
	
	private Queue seatQueue;

	@Autowired
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setSeatQueue(Queue seatQueue) {
		this.seatQueue = seatQueue;
	}
	
	public void sendToQueue(Seat seat, int quantity) {
		
		SeatInventory si = new SeatInventory(seat, quantity);
		
		template.send(seatQueue, (s) -> s.createObjectMessage(si));
	}
	
}

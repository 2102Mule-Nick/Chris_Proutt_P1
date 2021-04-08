package com.main.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.main.dto.ScreenInventory;
import com.main.pojo.Screen;

@Service
public class SeatMessageSender {

	private JmsTemplate template; 
	
	private Queue SeatQueue;

	@Autowired
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}
	
	public void setSeatQueue(Queue seatQueue) {
		SeatQueue = seatQueue;
	}

	public void sendToSeatQueue(Screen screen, int capacity) {
		
		ScreenInventory si = new ScreenInventory(screen, capacity);
		
		template.send(SeatQueue, (s) -> s.createObjectMessage(si));
	}

	
}

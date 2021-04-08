package com.main.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.main.dto.ScreenInventory;
import com.main.pojo.Screen;

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
	
	public void sendToSeatQueue(Screen screen, int quantity) {
		
		ScreenInventory si = new ScreenInventory(screen, quantity);
		
		template.send(seatQueue, (s) -> s.createObjectMessage(si));
	}
	
}

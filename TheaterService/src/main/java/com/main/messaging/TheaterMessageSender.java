package com.main.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.main.dto.TheaterInventory;
import com.main.pojo.Theater;

@Service
public class TheaterMessageSender {
	private JmsTemplate template;
	
	private Queue theaterQueue;

	public JmsTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	public Queue getTheaterQueue() {
		return theaterQueue;
	}

	@Autowired
	public void setTheaterQueue(Queue theaterQueue) {
		this.theaterQueue = theaterQueue;
	}
	
	public void sendToTheaterQueue(Theater theater, int screens) {
		
		TheaterInventory ti = new TheaterInventory(theater, screens);
		
		template.send(theaterQueue, (s) -> s.createObjectMessage(ti));
	}
}

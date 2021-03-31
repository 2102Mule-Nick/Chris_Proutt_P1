package com.main.messaging;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.main.dto.TicketInventory;
import com.main.pojo.Ticket;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;
	
	private Topic topic;
	
	private Queue inventoryQueue;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Topic getTopic() {
		return topic;
	}

	@Autowired
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Queue getInventoryQueue() {
		return inventoryQueue;
	}

	@Autowired
	public void setInventoryQueue(Queue inventoryQueue) {
		this.inventoryQueue = inventoryQueue;
	}
	
	public void simpleSend(String msg) {
		
		//	jmsTemplate.send(queue, (s) -> s.createTextMessage(msg));

		jmsTemplate.send(topic, (s) -> s.createTextMessage(msg));
		
	}
	
	
	public void sendToInventoryQueue(Ticket ticket, int quantity) {
		
		TicketInventory ii = new TicketInventory(ticket, quantity);
		
		jmsTemplate.send(inventoryQueue, (s) -> s.createObjectMessage(ii));
	}
}

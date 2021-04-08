package com.main.dao.messaging;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MovieMessageSender {

	private JmsTemplate template;
	
	private Topic movieTopic;

	@Autowired
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setMovieTopic(Topic movieTopic) {
		this.movieTopic = movieTopic;
	}
	
	public void sendToMovieTopic(String string) {
		template.send(movieTopic, (s) -> s.createTextMessage(string));
	}
}

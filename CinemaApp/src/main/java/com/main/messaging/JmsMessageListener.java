package com.main.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.main.configuration.AppConfiguration;

@Component
public class JmsMessageListener {
	
	@JmsListener(destination = AppConfiguration.MOVIE_TOPIC)
	public void NewMovieAdded(Message msg) {
		if(msg instanceof TextMessage) {
			msg.toString();
			System.out.println(msg);
		}
	}

}

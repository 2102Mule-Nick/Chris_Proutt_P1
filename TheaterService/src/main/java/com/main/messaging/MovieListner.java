package com.main.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.main.AppConfig;

@Service
public class MovieListner {
	
	@JmsListener(destination = AppConfig.MOVIE_TOPIC)
	public void NewMovieAdded(Message msg) {
		if(msg instanceof TextMessage) {
			try {
				String message = ((TextMessage) msg).getText();
				System.out.println(message);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}

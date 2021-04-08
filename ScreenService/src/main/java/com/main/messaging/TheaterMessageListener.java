package com.main.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.main.AppConfig;
import com.main.dto.TheaterInventory;
import com.main.exceptions.InvalidNumberOfScreens;
import com.main.service.ScreenService;

@Service
public class TheaterMessageListener {

	private ScreenService service;

	public ScreenService getService() {
		return service;
	}

	@Autowired
	public void setService(ScreenService service) {
		this.service = service;
	}
	
	@JmsListener(destination = AppConfig.THEATER_QUEUE)
	public void AddScreensToNewTheater(Message message) {
		System.out.println("Handling incoming message");
		
		if(message instanceof ObjectMessage) {
			ObjectMessage om = (ObjectMessage) message;
			
			try {
				TheaterInventory ti = (TheaterInventory) om.getObject();
				service.addScreensForTheater(ti.getTheater().getTheater_id(), ti.getScreens());
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (InvalidNumberOfScreens e) {
				e.printStackTrace();
			}
		}
	}
	
	
}

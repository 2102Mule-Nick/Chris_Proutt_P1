package com.main.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.main.AppConfig;
import com.main.dto.ScreenInventory;
import com.main.exceptions.InvalidSeatCapacity;
import com.main.service.SeatService;

@Service
public class JmsMessageListener {
	
	private SeatService service;
	
	public SeatService getService() {
		return service;
	}
	
	@Autowired
	public void setService(SeatService service) {
		this.service = service;
	}

	@JmsListener(destination = AppConfig.Seat_Queue)
	public void AddSeatsToNewTheater(Message message) {
		System.out.print("Handling incoming message");
		
		if(message instanceof ObjectMessage) {
			
			ObjectMessage om = (ObjectMessage)message;
			
			try {
				ScreenInventory si = (ScreenInventory) om.getObject();
				try {
					service.addSeatsForScreen(si.getScreen().getScreen_id(), si.getCapacity());
				} catch (InvalidSeatCapacity e) {
					e.printStackTrace();
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package com.main;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.main.configuration.AppConfiguration;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		
	}
	
private static void setUpActiveMQ() {
		
		BrokerService broker;
		
		try {
			broker = BrokerFactory.createBroker("broker:(" + AppConfiguration.BROKER_URL + ")");
			broker.getAdminView();
			broker.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

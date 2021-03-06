package com.main.messaging;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.main.pojo.Screen;

@Service
public class JmsMessageSender {

	private JmsTemplate template; 
	
	@Autowired
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

}

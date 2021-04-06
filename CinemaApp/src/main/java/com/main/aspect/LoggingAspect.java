package com.main.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger log;
	
	public Logger getLog() {
		return log;
	}

	@Autowired
	public void setLog(Logger log) {
		this.log = log;
	}
}

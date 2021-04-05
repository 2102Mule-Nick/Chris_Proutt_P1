package com.main.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.main.ws.MessageGen",
serviceName="messageGenService")
public class MessageGenImpl implements MessageGen {

	@Override
	public String getMessage() {
		return "Hi Brian";
	}

}
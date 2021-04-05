package com.main.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CreditCardAuthenticator {
	
	@WebMethod
	public Boolean authenticate(String string);

}

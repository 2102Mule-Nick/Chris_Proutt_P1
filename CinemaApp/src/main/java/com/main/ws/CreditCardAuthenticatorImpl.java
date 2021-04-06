package com.main.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.main.ws.CreditCardAuthenticator",
serviceName = "authenticate")
public class CreditCardAuthenticatorImpl implements CreditCardAuthenticator {

	@Override
	public Boolean authenticate(String string) {
		string = string.replaceAll(" ", "");
		if(string.length() <= 1) {
			return false;
		}
		
		for(char ch : string.toCharArray()) {
			if(Character.isDigit(ch) == false) {
				return false;
			}
		}
		
		int[] numbers = new int[string.length()];
		
		for(int i = 0; i < string.length(); i++) {
			numbers[i] = Integer.parseInt(string.substring(i, i + 1));
		}
		
		for(int i = numbers.length - 2; i >= 0; i-=2) {
			int temp = numbers[i] * 2;
			
			if(temp > 9) {
				temp = temp % 10 + 1;
			}
			numbers[i] = temp;
		}
	    
	    int sum = 0;
        
	    for(int number : numbers) {
	    	sum += number;
	    }
	    
        return (sum % 10 == 0);
	}

}

package com.main.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.main.pojo.Booking;

@WebService
public interface BookingService {

	@WebMethod
	public void createBooking(Booking Booking);
}

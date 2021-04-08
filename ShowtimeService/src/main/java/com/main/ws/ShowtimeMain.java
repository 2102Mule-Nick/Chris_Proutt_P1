package com.main.ws;

public class ShowtimeMain {
	public static void main(String[] args) {
		ShowTimeCreatorImplService showtimeGen = new ShowTimeCreatorImplService();
		
		ShowTimeCreator showtimePort = showtimeGen.getShowTimeCreatorImplPort();
		
	}
}

package com.main.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.ui.Menu;

@Component
public class WelcomeMenu implements Menu {

	private Scanner scan;

	private Menu loginMenu;
	
	@Autowired
	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	@Autowired
	public void setLoginMenu(Menu loginMenu) {
		this.loginMenu = loginMenu;
	}
	
	@Autowired
	public void setRegistrationMenu(Menu registrationMenu) {
		this.registrationMenu = registrationMenu;
	}

	@Autowired
	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}

	private Menu registrationMenu;

	private Menu nextMenu;
	
	
	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void display() {
		System.out.println("Welcome to Cinema Tickets");
		System.out.println("Type in the option you'd like");
		System.out.println("1 - Login");
		System.out.println("2 - Register");
		System.out.println("3 - Exit");
		System.out.println("Would you like to login, register, or update account info?");
		int option = scan.nextInt();

		if (option == 1) {
			nextMenu = loginMenu;
		} else if (option == 2) {
			nextMenu = registrationMenu;
		} else if (option == 3 ) {
			System.exit(0);
		} else {
			System.out.println("invalid input");
			// redirect user to same welcome menu
			nextMenu = this;
		}
	}

	@Override
	public Menu previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

}

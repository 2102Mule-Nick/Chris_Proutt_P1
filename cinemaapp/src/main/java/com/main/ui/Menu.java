package com.main.ui;

import java.util.Scanner;

public interface Menu {
	
	public Menu advance();
	
	public void display();
	
	public Menu previous();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);
	
}

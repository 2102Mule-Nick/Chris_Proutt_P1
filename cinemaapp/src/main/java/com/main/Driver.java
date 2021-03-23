package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.main.configuration.AppConfiguration;
import com.main.ui.Menu;
import com.main.ui.WelcomeMenu;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		Menu menu = appContext.getBean("welcomeMenu", WelcomeMenu.class);
		
		do {
			menu.display();
			menu = menu.advance();
		} while (menu != null);
		
	}

}

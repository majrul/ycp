package com.cdac.v2;

import java.util.Date;

public class ConsoleLogger {

	public void log(String message) {
		//System.out.println("[INFO] ["+new Date()+"] " + message);
		log(message, LogLevel.INFO);
	}
	
	public void log(String message, LogLevel level) {
		switch(level) {
		case INFO:
			System.out.println("[INFO] ["+new Date()+"] " + message);
			break;
		case WARNING:
			System.out.println("[WARN] ["+new Date()+"] " + message);
			break;
		case ERROR:
			System.out.println("[ERROR] ["+new Date()+"] " + message);
			break;
		}
	}
}

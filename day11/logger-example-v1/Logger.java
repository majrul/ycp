package com.cdac.v1;

import java.util.Date;

public class Logger {

	public void log(String message) {
		System.out.println("[INFO] ["+new Date()+"] " + message);
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

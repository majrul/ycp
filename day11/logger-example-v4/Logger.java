package com.cdac.v4;

public abstract class Logger {

	public void log(String message) {
		log(message, LogLevel.INFO);
	}

	//public void log(String message, LogLevel level) { }
	public abstract void log(String message, LogLevel level);
	
	/*static void info() {
		
	}*/
}

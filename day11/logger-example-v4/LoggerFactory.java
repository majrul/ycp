package com.cdac.v4;

public class LoggerFactory {

	/*public static Logger getLoggerInstance() {
		return new ConsoleLogger();
	}*/
	
	public static Logger getLoggerInstance(String type) {
		if(type.equals("console"))
			return new ConsoleLogger();
		else if(type.equals("file"))
			return new FileLogger();
		else
			return null; //throw an exception instead
	}
}

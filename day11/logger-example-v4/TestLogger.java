package com.cdac.v4;

import java.util.Calendar;

public class TestLogger {

	public static void main(String[] args) {
		//Logger.info();
		//ConsoleLogger l = new ConsoleLogger();
		//FileLogger l = new FileLogger();
		//Calendar c = Calendar.getInstance();
		//Logger l = LoggerFactory.getLoggerInstance();
		Logger l = LoggerFactory.getLoggerInstance("file");
		l.log("Some message");
		l.log("Again some message", LogLevel.ERROR);
		l.log("Some warning", LogLevel.WARNING);
	}
}

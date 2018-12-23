package com.cdac.v3;

public class TestLogger {

	public static void main(String[] args) {
		//Logger.info();
		//ConsoleLogger l = new ConsoleLogger();
		FileLogger l = new FileLogger();
		l.log("Some message");
		l.log("Again some message", LogLevel.ERROR);
		l.log("Some warning", LogLevel.WARNING);
	}
}

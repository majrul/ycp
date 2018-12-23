package com.cdac.v2;

public class TestLogger {

	public static void main(String[] args) {
		//ConsoleLogger l = new ConsoleLogger();
		FileLogger l = new FileLogger();
		l.log("Some message");
		l.log("Again some message", LogLevel.ERROR);
		l.log("Some warning", LogLevel.WARNING);
	}
}

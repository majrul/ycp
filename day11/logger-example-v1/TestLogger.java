package com.cdac.v1;

public class TestLogger {

	public static void main(String[] args) {
		Logger l = new Logger();
		l.log("Some message");
		l.log("Again some message", LogLevel.ERROR);
	}
}

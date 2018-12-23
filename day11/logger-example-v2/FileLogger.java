package com.cdac.v2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {

	public void log(String message) {
		log(message, LogLevel.INFO);
	}
	
	public void log(String message, LogLevel level) {
		try(FileWriter fw = new FileWriter("app.log",true)) {
			switch(level) {
			case INFO:
				fw.write("\n[INFO] ["+new Date()+"] " + message);
				break;
			case WARNING:
				fw.write("\n[WARN] ["+new Date()+"] " + message);
				break;
			case ERROR:
				fw.write("\n[ERROR] ["+new Date()+"] " + message);
				break;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

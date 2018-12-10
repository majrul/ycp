package com.cdac.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		try {
			inFile = new FileInputStream("sample.txt");
			int ch = 0;
			while(true) {
				ch = inFile.read(); //read 1 byte at a time
				if(ch == -1) //EOF
					break;
				System.out.print((char)ch);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Please check the no. of your glasses!");
		}
		catch(IOException e) {
			System.out.println("It seems the HDD is curropted. Please bang it once on the floor and try again!");
		}
		finally {
			try { inFile.close(); } catch(Exception e) { }
		}
	}
}

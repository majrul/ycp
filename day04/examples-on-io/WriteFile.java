package com.cdac.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	public static void main(String[] args) {
		FileOutputStream outFile = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter filename : " );
		String filename = sc.nextLine();
		
		try {
			outFile = new FileOutputStream(filename);
			
			System.out.println("Enter content of the file :");
			String content = sc.nextLine();
			
			outFile.write(content.getBytes());
		}
		catch(FileNotFoundException e) {
			System.out.println("Please check the no. of your glasses!");
		}
		catch(IOException e) {
			System.out.println("It seems the HDD is curropted. Please bang it once on the floor and try again!");
		}
		finally {
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}

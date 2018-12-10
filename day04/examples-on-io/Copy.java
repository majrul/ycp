package com.cdac.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This java program will copy the content of one file to another file
 * 
 * @author majrul
 *
 * THINGS TO TRY IN THIS EXAMPLE:
 * 1) First see if we are able to copy a plain text file
 * using FileInputStream/FileOutputStream
 * and then use FileReader/FileWriter instead of FileInputStream/FileOutputStream
 * Main thing we need to check is if the generated file is getting curropted or not
 * 2) To understand the difference between Reader/Writer and InputStream/OutputStream,
 * modify the code to read/write a .jpg file instead of .txt file and then see
 * which version will curropt the file
 * 3) Then we will try to copy a huge file (for ex: 100 MB size) to observe that the
 * code is taking too long to complete the copy process. Try with any .zip/.exe/.pdf
 * or any other file format but make sure it's atleast more than 20MB  
 */
public class Copy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		//FileReader inFile = null;
		//FileWriter outFile = null;
		try {
			inFile = new FileInputStream("sample.txt");
			outFile = new FileOutputStream("copyofsample.txt");

			//inFile = new FileInputStream("/Volumes/Mojave/users/majrul/Downloads/VirtualBox-5.2.18-124319-OSX.dmg");
			//outFile = new FileOutputStream("/Volumes/Mojave/users/majrul/Downloads/CopyOfVirtualBox-5.2.18-124319-OSX.dmg");

			//inFile = new FileReader("sample.txt");
			//outFile = new FileWriter("copyofsample.txt");
			
			int ch = 0;
			while(true) {
				ch = inFile.read();
				if(ch == -1)
					break;
				outFile.write(ch);
			}
			System.out.println("File copied successfully!");
		}
		catch(FileNotFoundException e) {
			System.out.println("Please check the no. of your glasses!");
		}
		catch(IOException e) {
			System.out.println("It seems the HDD is curropted. Please bang it once on the floor and try again!");
		}
		finally {
			try { inFile.close(); } catch(Exception e) { }
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}

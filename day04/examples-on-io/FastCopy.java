package com.cdac.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This java program will copy the content of one file to another file
 * with the help of buffering
 * 
 * @author majrul
 *
 */
public class FastCopy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		BufferedInputStream inBuffer = null;
		BufferedOutputStream outBuffer = null;
		try {
			inFile = new FileInputStream("/Volumes/Mojave/users/majrul/Downloads/VirtualBox-5.2.18-124319-OSX.dmg");
			outFile = new FileOutputStream("/Volumes/Mojave/users/majrul/Downloads/CopyOfVirtualBox-5.2.18-124319-OSX.dmg");
			inBuffer = new BufferedInputStream(inFile, 1024*16);
			outBuffer = new BufferedOutputStream(outFile, 1024*16);
			
			int ch = 0;
			while(true) {
				ch = inBuffer.read();
				if(ch == -1)
					break;
				outBuffer.write(ch);
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
			try { inBuffer.close(); } catch(Exception e) { }
			try { outBuffer.close(); } catch(Exception e) { }
			try { inFile.close(); } catch(Exception e) { }
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}

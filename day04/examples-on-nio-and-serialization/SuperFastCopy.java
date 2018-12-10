package com.cdac.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This java program will copy the content of one file to another file
 * with the help of NIO (Non blocking IO)
 * 
 * @author majrul
 *
 */
public class SuperFastCopy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inFile = new FileInputStream("/Volumes/Mojave/users/majrul/Downloads/VirtualBox-5.2.18-124319-OSX.dmg");
			outFile = new FileOutputStream("/Volumes/Mojave/users/majrul/Downloads/CopyOfVirtualBox-5.2.18-124319-OSX.dmg");
			inChannel = inFile.getChannel();
			outChannel = outFile.getChannel();
			
			//ByteBuffer buffer = ByteBuffer.allocate(1024*16);
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024*16);

			long ms1 = System.currentTimeMillis();
			while(true) {
				int ch = inChannel.read(buffer);
				if(ch == -1)
					break;
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear();
			}
			long ms2 = System.currentTimeMillis();
			
			System.out.println("File copied successfully in " + (ms2 - ms1) + " ms approx");
		}
		catch(FileNotFoundException e) {
			System.out.println("Please check the no. of your glasses!");
		}
		catch(IOException e) {
			System.out.println("It seems the HDD is curropted. Please bang it once on the floor and try again!");
		}
		finally {
			try { inChannel.close(); } catch(Exception e) { }
			try { outChannel.close(); } catch(Exception e) { }
			try { inFile.close(); } catch(Exception e) { }
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}

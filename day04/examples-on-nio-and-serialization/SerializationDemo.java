package com.cdac.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	private static void serialize() throws Exception {
		Employee emp = new Employee(1001, "Majrul", 999999999.99);
		
		FileOutputStream outFile = new FileOutputStream("emp.txt");
		ObjectOutputStream os = new ObjectOutputStream(outFile);
		
		os.writeObject(emp);
		
		os.close();
		outFile.close();
	}
	
	private static void deserialize() throws Exception {
		FileInputStream outFile = new FileInputStream("emp.data");
		ObjectInputStream os = new ObjectInputStream(outFile);
		
		Employee emp = (Employee) os.readObject();
		System.out.println(emp.getEmpno() + "," + emp.getName() + "," + emp.getSalary());
		
		os.close();
		outFile.close();
	}
	
	public static void main(String[] args) throws Exception {
		serialize();
		//deserialize();
	}
}

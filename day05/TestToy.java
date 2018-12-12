package com.cdac.objectclass;

public class TestToy {

	public static void main(String[] args) throws CloneNotSupportedException {
		//throw new NullPointerException();
		
		Toy t1 = new Toy("RC Car", 6);
		t1.addBattery("Sony");
		t1.addBattery("Sony");
		t1.addBattery("Sony");
		t1.addBattery("Nippo");
		t1.addBattery("Eveready");
		t1.addBattery("Sony");
		
		Toy t2 = (Toy) t1.clone();
		System.out.println(t1);
		System.out.println(t2);
		
		t1.getBatteries()[0].setMake("Philips");
		System.out.println(t1);
		System.out.println(t2);
	}
}

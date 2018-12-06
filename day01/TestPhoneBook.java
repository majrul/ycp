package com.cdac.basics.oo;

public class TestPhoneBook {

	public static void main(String[] args) {
		PhoneBook ph1 = new PhoneBook(10);
		
		Entry e1 = new Entry();
		e1.setName("Majrul");
		e1.setNumber("9820101010");
		e1.setEmail("majrul@gmail.com");
		ph1.store(e1);
		
		Entry e2 = new Entry();
		e2.setName("Majrul");
		e2.setNumber("9820101010");
		e2.setEmail("majrul@gmail.com");
		ph1.store(e2);
		
		ph1.display();
	}
}

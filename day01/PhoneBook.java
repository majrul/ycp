package com.cdac.basics.oo;

public class PhoneBook {

	private Entry[] entries;// = new Entry[100];
	private int count;
	
	//constructor(s)
	public PhoneBook() {
		entries = new Entry[100];
	}
	
	public PhoneBook(int noOfEntries) {
		entries = new Entry[noOfEntries];
	}

	//=========user defined methods==========//
	
	void store(Entry entry) {
		entries[count++] = entry;
	}
	
	Entry searchByName(String name) {
		for(int i=0;i<count;i++)
			if(entries[i].getName() == name)
				return entries[i];
		return null; //throw an exception instead
	}

	/*Entry searchByNumber(String number) {
		
	}

	Entry searchByEmail(String email) {
		
	}*/

	//TODO : Write the code to display all the entries here
	void display() {
		
	}
	
	void clear() {
		
	}
}

package com.cdac.objectclass;

public class TestPerson {

	public static void main(String[] args) {
		Person p1 = new Person("Majrul", 99);
		System.out.println(p1.getName() + " , " + p1.getAge());
		System.out.println(p1); // cout << p1;
		
		Person p2 = new Person("Majrul", 99);
		System.out.println(p1 == p2); //reference comparison
		System.out.println(p1.equals(p2)); //value comparison
		
		String s1 = new String("Java");
		String s2 = new String("Java");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		//Person p3 = new Person(p1.getName(), p1.getAge());
		try {
			Person p3 = (Person) p1.clone();
			System.out.println("====>"+p3);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Address addr = new Address("Mumbai", 4000083);
		Person p4 = new Person("Majrul", 99, addr);
		try {
			Person p5 = (Person) p4.clone();
			System.out.println(p4.getAddress().getCity());
			System.out.println(p5.getAddress().getCity());
			p4.getAddress().setCity("Delhi");
			System.out.println(p4.getAddress().getCity());
			System.out.println(p5.getAddress().getCity());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		p1 = p2 = null;
		System.gc(); //this method is not recommended to be used in projects
	}
}

package com.cdac.objectclass;

/**
 * 
 * @author majrul
 * 
 * Things to try in this example:
 * 1) First we saw toString method
 * which is invoked internally by print/println when
 * we pass an Object to it
 * 2) Then we saw the difference between == and equals method
 * If we wish to compare the data members of two objects are equal or not,
 * we should always use equals method, not == operator
 * 3) After this we had a quick look at hashCode method
 * hashCode method should be overriden along with equals always
 * hashCode method is used by hashing algorithms
 * 4) finalize method is called by the GC when the object
 * is eligible for GC. Not so important method this is, but good to know
 * 5) clone() method is used to create a copy of an Object
 * By default clone method does a shallow copy, which means
 * it will not clone the internal members of the object
 * 
 */
public class Person /*extends Object*/ implements Cloneable {

	private String name;
	private int age;
	//private int hiddenVariable;
	private Address address;
	
	public Person() {
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
/*	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
*/	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/
	
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
	
	/*@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize called..");
	}*/
	
	//shallow copy
	/*@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
	
	//deep copy
	/*@Override
	public Object clone() throws CloneNotSupportedException {
		Person p = (Person) super.clone();
		if(this.address != null) {
			Address a = (Address) address.clone();
			p.setAddress(a);
		}
		return p;
	}*/
}

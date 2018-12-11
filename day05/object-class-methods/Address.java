package com.cdac.objectclass;

public class Address implements Cloneable {

	private String city;
	private int pincode;
	
	public Address() {
	}
	public Address(String city, int pincode) {
		super();
		this.city = city;
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

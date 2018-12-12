package com.cdac.objectclass;

public class Battery implements Cloneable {

	private static int sequence = 100;
	
	private String make;
	private int batteryNumber = ++sequence;
	
	public Battery() {
	}
	public Battery(String make) {
		this.make = make;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getBatteryNumber() {
		return batteryNumber;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Battery [make=" + make + ", batteryNumber=" + batteryNumber + "]";
	}
	
	
}

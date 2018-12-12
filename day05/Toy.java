package com.cdac.objectclass;

import java.util.Arrays;

public class Toy implements Cloneable {

	private String name;
	private Battery[] batteries;
	private int count;
	
	public Toy() {
	}
	public Toy(String name, int noOfBatteries) {
		this.name = name;
		this.batteries = new Battery[noOfBatteries];
	}
	
	public void addBattery(String make) {
		Battery battery = new Battery(make);
		batteries[count++] = battery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Battery[] getBatteries() {
		return batteries;
	}
	public void setBatteries(Battery[] batteries) {
		this.batteries = batteries;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Toy t = (Toy) super.clone();
		Battery[] batt = new Battery[batteries.length];
		for(int i=0;i<batteries.length;i++)
			batt[i] = (Battery) batteries[i].clone();
		t.setBatteries(batt);
		return t;
	}
	
	@Override
	public String toString() {
		return "Toy [name=" + name + ", batteries=" + Arrays.toString(batteries) + "]";
	}
	
	
}

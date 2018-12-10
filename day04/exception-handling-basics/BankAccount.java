package com.cdac.exceptionhandling;

public class BankAccount {

	private int acno;
	private String name;
	private double balance;
	
	public BankAccount(int acno, String name, double balance) {
		this.acno = acno;
		this.name = name;
		this.balance = balance;
	}

	//public double withdraw(int amount) throws Error {
	public double withdraw(int amount) throws Exception {
	//public double withdraw(int amount) throws RuntimeException {
		if(amount > balance) {
			//System.out.println("Insufficient Balance!");
			Exception e = new Exception("Insufficient Balance!");
			//RuntimeException e = new RuntimeException("Insufficient Balance!");
			//Error e = new Error("Insufficient Balance!");
			throw e;
		}
		else {
			balance -= amount;
			return balance;
		}
	}
	
	public static void main(String[] args) {
		BankAccount bankAcc = new BankAccount(1, "Majrul", 5000);
		try {
			double balance = bankAcc.withdraw(6000);
			System.out.println("Balance left " + balance);
		//} catch (Error e) {
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
}

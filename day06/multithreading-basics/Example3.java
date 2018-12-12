package com.cdac.threading;

/*
 * In this example, we saw what happens when multiple threads try to read/write
 * data in the same object at the same time. The problem in below code
 * is that if multiple threads try to withdraw money at the same time
 * from the same account, it will work and the bank will be at loss.
 * By synchronizing withdraw method, we tell the jvm to allow only
 * one Thread at a time to execute the code so that there is no concurrency
 * issue in this code.
 */
class BankAccount {
	
	int acno;
	double balance;
	
	BankAccount(int acno, double balance) {
		this.acno = acno;
		this.balance = balance;
	}

	/*synchronized*/ void withdraw(double amount) {
		try { Thread.sleep(100); } catch(InterruptedException e) { }
		if(amount < balance) {
			try { Thread.sleep(100); } catch(InterruptedException e) { }
			balance -= amount;
			try { Thread.sleep(100); } catch(InterruptedException e) { }
			System.out.println("Balance left " + balance);
		}
		else {
			System.out.println("Insufficient Balance!");
		}
	}
}

class Transaction implements Runnable {

	BankAccount bankAccount;
	
	Transaction(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		//BankAccount bankAcc = new BankAccount(acno, balance)
		bankAccount.withdraw(5000);
	}
}

public class Example3 {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount(12345, 6000);
		Transaction tx1 = new Transaction(bankAccount);
		Transaction tx2 = new Transaction(bankAccount);
		Thread th1 = new Thread(tx1);
		Thread th2 = new Thread(tx2);
		th1.start();
		th2.start();
	}
}

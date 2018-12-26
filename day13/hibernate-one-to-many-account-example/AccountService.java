package com.cdac.service;

import java.util.Date;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Account;
import com.cdac.entity.AccountActivity;

//business logic
public class AccountService {

	public void openAccount(Account acc) {
		GenericDao dao = new GenericDao();
		dao.add(acc);
	}
	
	public void withdraw(int acno, double amount) {
		GenericDao dao = new GenericDao();
		
		Account acc = (Account) dao.fetch(Account.class, acno);
		acc.setBalance(acc.getBalance() - amount);
		dao.update(acc);
		
		AccountActivity act = new AccountActivity();
		act.setDate(new Date());
		act.setAmount(amount);
		act.setType("Withdraw");
		act.setAccount(acc);
		dao.add(act);
	}
	
	public void deposit(int acno, double amount) {
		GenericDao dao = new GenericDao();
		
		Account acc = (Account) dao.fetch(Account.class, acno);
		acc.setBalance(acc.getBalance() + amount);
		dao.update(acc);
		
		AccountActivity act = new AccountActivity();
		act.setDate(new Date());
		act.setAmount(amount);
		act.setType("Deposit");
		act.setAccount(acc);
		dao.add(act);
	}
	
	public void transfer(int fromacno, int toacno, double amount) {
		GenericDao dao = new GenericDao();

		Account fromacc = (Account) dao.fetch(Account.class, fromacno);
		Account toacc = (Account) dao.fetch(Account.class, toacno);

		fromacc.setBalance(fromacc.getBalance() - amount);
		toacc.setBalance(toacc.getBalance() + amount);
		dao.update(fromacc);
		dao.update(toacc);
		
		AccountActivity act1 = new AccountActivity();
		act1.setDate(new Date());
		act1.setAmount(amount);
		act1.setType("TransferredMoney");
		act1.setAccount(fromacc);
		dao.add(act1);

		AccountActivity act2 = new AccountActivity();
		act2.setDate(new Date());
		act2.setAmount(amount);
		act2.setType("ReceivedMoney");
		act2.setAccount(toacc);
		dao.add(act2);
	}
	
	public double checkBalance(int acno) {
		GenericDao dao = new  GenericDao();
		Account acc = (Account) dao.fetch(Account.class, acno);
		return acc.getBalance();
	}
} 

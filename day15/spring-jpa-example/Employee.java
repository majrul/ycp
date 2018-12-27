package com.cdac.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO class
//JAVABEAN class
@Entity
@Table(name = "TBL_EMP")
public class Employee {

	@Id
	private int empno;
	
	private String name;
	private double salary;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}

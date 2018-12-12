package com.cdac.jdbc;

public class EmployeeDaoTest {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		dao.insert(1001, "Majrul", 1000);
	}
}

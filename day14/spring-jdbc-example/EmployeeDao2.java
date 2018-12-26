package com.cdac.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("empDao2")
public class EmployeeDao2 {

	//dependency
	@Autowired
	private DataSource dataSource; //alternative to DriverManager class
	
	public void insert(int empno, String name, double salary) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("insert into TBL_EMP values(?,?,?)",
				empno,
				name,
				salary);
	}
}

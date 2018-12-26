package com.cdac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDao")
public class EmployeeDao {

	//dependency
	@Autowired
	private DataSource dataSource; //alternative to DriverManager class
	
	public void insert(int empno, String name, double salary) {
		Connection conn = null;
		PreparedStatement stmt = null; //to help us in executing SQL statements
		try {
			conn = dataSource.getConnection();
			String sql = "insert into TBL_EMP values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, empno);
			stmt.setString(2, name);
			stmt.setDouble(3, salary);
			stmt.executeUpdate(); //DML
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try { stmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
}

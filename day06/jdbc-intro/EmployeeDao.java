package com.cdac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//Data Access Object
//In Java, classes will contain database interaction code
//are referred to as Dao classes
public class EmployeeDao {

	//public void insert(Employee emp) {
	//OR
	public void insert(int empno, String name, double salary) {
		Connection conn = null;
		PreparedStatement stmt = null; //to help us in executing SQL statements
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@ipaddress:1521:xe";
			String username = "shyamdada";
			String password = "radha";
			conn = DriverManager.getConnection(url, username, password);
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
	
	//TODO : Practice update and delete as well
	//Also try fetching/select queries as well
	
}

	
	
	
	
	
	
	
package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDao")
public class EmployeeDao {

	//dependency
	@Autowired
	private DataSource dataSource; //alternative to DriverManager class
	
	public void insert(Employee emp) {
		Connection conn = null;
		PreparedStatement stmt = null; //to help us in executing SQL statements
		try {
			conn = dataSource.getConnection();
			String sql = "insert into TBL_EMP values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp.getEmpno());
			stmt.setString(2,emp.getName());
			stmt.setDouble(3, emp.getSalary());
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
	
	public List<Employee> fetchAll() {
		Connection conn = null;
		PreparedStatement stmt = null; //to help us in executing SQL statements
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from TBL_EMP";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			List<Employee> emps = new ArrayList<>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emps.add(emp);
			}
			return emps;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try { stmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
}

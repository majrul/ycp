package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//TODO: Try injecting the JdbcTemplate instead of DataSource

@Component("empDao2")
public class EmployeeDao2 {

	//dependency
	@Autowired
	private DataSource dataSource; //alternative to DriverManager class
	
	public void insert(Employee emp) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("insert into TBL_EMP values(?,?,?)",
				emp.getEmpno(),
				emp.getName(),
				emp.getSalary());
	}
	
	public List<Employee> fetchAll() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		List<Employee> emps = jt.query("select * from TBL_EMP", new EmployeeRowMapper());
		return emps;
	}

	class EmployeeRowMapper implements RowMapper<Employee> {
		
		@Override
		public Employee mapRow(ResultSet rs, int index) throws SQLException {
			Employee emp = new Employee();
			emp.setEmpno(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			return emp;
		}
	}

}

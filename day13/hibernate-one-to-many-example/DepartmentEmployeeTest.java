package com.cdac.test;

import org.junit.Test;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Department;
import com.cdac.entity.Employee;

public class DepartmentEmployeeTest {

	@Test
	public void addDepartment() {
		Department d1 = new Department();
		d1.setDeptno(10);
		d1.setName("HR");
		d1.setLocation("Andheri");

		Department d2 = new Department();
		d2.setDeptno(20);
		d2.setName("IT");
		d2.setLocation("Airoli");

		GenericDao dao = new GenericDao();
		dao.add(d1);
		dao.add(d2);
	}
	
	@Test
	public void addEmployee() {
		GenericDao dao = new GenericDao();
		Department d1 = (Department) dao.fetch(Department.class, 10);
		
		Employee e1 = new Employee();
		e1.setEmpno(1001);
		e1.setName("Majrul");
		e1.setSalary(9999);
		e1.setDept(d1);
		
		dao.add(e1);
	}
}

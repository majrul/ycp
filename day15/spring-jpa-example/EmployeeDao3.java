package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("empDao3")
public class EmployeeDao3 {

	//@Autowired //Autowired doesn't works in this case, 
	//instead we use @PersistenceContext to inject EntityManager object
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insert(Employee emp) {
		em.persist(emp);
	}
	
	public List<Employee> fetchAll() {
		Query q = em.createQuery("select e from Employee e");
		List<Employee> emps = q.getResultList();
		return emps;
	}
}

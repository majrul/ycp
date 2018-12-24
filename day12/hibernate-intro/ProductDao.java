package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Product;

public class ProductDao {

	public void add(Product product) {
		//Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		//Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		//Step 3. Start a Transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete whatever we want
		em.persist(product); //this line will generate insert query
		
		tx.commit();
		
		//below code should be in finally block
		em.close();
		emf.close();
	}
	
	public void update(Product product) {
		
	}
	
	public void remove(int productId) {
		
	}
	
	public Product fetch(int productId) {
		return null;
	}
}

package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Product;

public class ProductDao {

	public void add(Product product) {
		// Step 1. Create EntityManagerFactory object
		//At this stage META-INF/persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		
		// Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		// Step 3. Start a Transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Now we can insert/update/delete whatever we want
		em.persist(product); // this line will generate insert query

		tx.commit();

		// below code should be in finally block
		em.close();
		emf.close();
	}

	public void update(Product product) {
		// Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		// Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		// Step 3. Start a Transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Now we can insert/update/delete whatever we want
		em.merge(product); // this line will generate update query

		tx.commit();

		// below code should be in finally block
		em.close();
		emf.close();
	}

	public void remove(int productId) {
		// Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		// Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
		// Step 3. Start a Transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Product p = em.find(Product.class, productId);
		// Now we can insert/update/delete whatever we want
		em.remove(p); // this line will generate delete query

		tx.commit();

		// below code should be in finally block
		em.close();
		emf.close();
	}

	public Product fetch(int productId) {
		// Step 1. Create EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		// Step 2. Create EntityManager object
		EntityManager em = emf.createEntityManager();
	
		try {
			Product p = em.find(Product.class, productId); //select
			return p;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Product> fetchAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		EntityManager em = emf.createEntityManager();
		
		try {
			Query q = em.createQuery("select p from Product p"); //JPQL
			return q.getResultList();
		}
		finally {
			em.close();
			emf.close();
		}
		
	}
}

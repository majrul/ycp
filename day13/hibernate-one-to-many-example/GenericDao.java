package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Product;

public class GenericDao {

	public void add(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(obj);

		tx.commit();

		em.close();
		emf.close();
	}
	
	public Object fetch(Class classname, int pk) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		EntityManager em = emf.createEntityManager();
	
		try {
			Object o = em.find(classname, pk); //select
			return o;
		}
		finally {
			em.close();
			emf.close();
		}

	}

}

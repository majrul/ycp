package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Account;

public class AccountAndActivityDao extends GenericDao {

	public List<Account> fetchAccountsWithBalance(double balance) {
		//select a from Account a where a.balance >= :bal
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-demo");
		EntityManager em = emf.createEntityManager();
		
		try {
			String jpql = "select a from Account a where a.balance >= :bal";
			Query q = em.createQuery(jpql); //JPQL
			q.setParameter("bal", balance);
			return q.getResultList();
		}
		finally {
			em.close();
			emf.close();
		}
	}
}

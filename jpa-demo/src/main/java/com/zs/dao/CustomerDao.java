package com.zs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Customer;

public class CustomerDao {
	private EntityManagerFactory emf;
	
	public CustomerDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public void save(Customer c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(c);
		txn.commit();
	}
	
	public Customer findById(int custId) {
		EntityManager em = emf.createEntityManager();
		Customer c = em.find(Customer.class, custId);
		return c;
	}
	
	public List<Customer> list() {
		EntityManager em = emf.createEntityManager();
		Query jpaQuery = em.createQuery("FROM Customer");
		return jpaQuery.getResultList();
	}
	
	public void delete(int custId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Customer c = em.find(Customer.class, custId);
		em.remove(c);
		txn.commit();
	}
}

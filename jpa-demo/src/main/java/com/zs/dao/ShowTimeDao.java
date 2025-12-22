package com.zs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zs.entity.Movie;
import com.zs.entity.Multiplex;

public class ShowTimeDao {
	private EntityManagerFactory factory;
	
	public ShowTimeDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean add(Object obj) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			em.persist(obj);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public boolean addMovieToMultiplex(int movId, int mpexId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			Movie movie = em.find(Movie.class, movId);
			Multiplex multiplex = em.find(Multiplex.class, mpexId);
			movie.getMultiplexes().add(multiplex);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public boolean delete(int id, String cls) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			Object obj = null;
			if(cls.equals("Movie")) 
				obj = em.find(Movie.class, id);
			else
				obj = em.find(Multiplex.class, id);
			em.remove(obj);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public Object findById(int id, Class cls) {
		EntityManager em = factory.createEntityManager();
		return em.find(cls, id);
	}
}






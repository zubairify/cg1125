package com.zs.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Flight;
import com.zs.ext.FlightNotFoundException;

public class FlightDao {
	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Flight f) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			em.persist(f);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}
	
	public Optional<Flight> findByNo(int fno) throws FlightNotFoundException {
		EntityManager em = emf.createEntityManager();
		Flight f = em.find(Flight.class, fno);
		if(f == null)
			throw new FlightNotFoundException("Flight not found with no: " + fno);
		return Optional.of(f);
	}
	
	public List<Flight> allFlights() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Flight");
		return query.getResultList();
	}
	
	public List<Flight> byCarrier(String carrier) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("ByCarrier");
		query.setParameter("car", carrier);
		return query.getResultList();
	}
	
	public List<Flight> byRoute(String src, String dest) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("ByRoute");
		query.setParameter(1, src);
		query.setParameter(2, dest);
		return query.getResultList();
	}
	
	public boolean delete(int fno) throws FlightNotFoundException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			Flight f = em.find(Flight.class, fno);
			if(f == null)
				throw new FlightNotFoundException("Flight not found with no: " + fno);
			em.remove(f);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			throw new FlightNotFoundException(e.getMessage());
		}
	}
}

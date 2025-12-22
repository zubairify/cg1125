package com.zs.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Flight;
import com.zs.entity.Passenger;

public class PassengerDao {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Passenger p, int fno) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Flight f = mgr.find(Flight.class, fno);
			p.setFlight(f);
			mgr.persist(p);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}
	
	public Passenger findById(int pid) {
		EntityManager mgr = emf.createEntityManager();
		return mgr.find(Passenger.class, pid);
	}
	
	public List<Passenger> allPassenger() {
		EntityManager mgr = emf.createEntityManager();
		return mgr.createQuery("FROM Passenger").getResultList();
	}
	
	public List<Passenger> itinarary(String src, String dest, LocalDate tdate) {
		EntityManager mgr = emf.createEntityManager();
		Query query = mgr.createQuery("SELECT p FROM Flight f JOIN f.passengers p WHERE" +
				" f.source=:src AND f.destination=:dest AND p.travelDate=:td");
		query.setParameter("src", src);
		query.setParameter("dest", dest);
		query.setParameter("td", tdate);
		return query.getResultList();
	}
}









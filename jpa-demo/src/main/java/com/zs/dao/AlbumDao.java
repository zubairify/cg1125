package com.zs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Album;

public class AlbumDao {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public List<Album> findByGenre(String genre) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Album WHERE genre=:gen");
		query.setParameter("gen", genre);
		return query.getResultList();
	}
}


package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.ShowTimeDao;
import com.zs.entity.Movie;
import com.zs.entity.Multiplex;

public class TestShowsDao {
	private static ShowTimeDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new ShowTimeDao();
	}
	
	@Test
	public void testAddMovie() {
		Movie m1 = new Movie();
		m1.setMovId(101); m1.setTitle("Inception");
		assertTrue(dao.add(m1));
	}
	
	@Test
	public void testAddMultiplex() {
		Multiplex p1 = new Multiplex();
		p1.setMpexId(201); p1.setName("PVR");
		assertTrue(dao.add(p1));
	}
	
	@Test
	public void testAddMovieToMpex() {
		assertTrue(dao.addMovieToMultiplex(101, 201));
	}
	
	@Test
	public void testDelMovie() {
		assertTrue(dao.delete(101, "Movie"));
	}
	
	@Test
	public void testDelMpex() {
		assertTrue(dao.delete(201, "Multiplex"));
	}
	
	@Test
	public void testFindMovie() {
		Movie m = (Movie)dao.findById(101, Movie.class);
		assertNotNull(m);
		System.out.println("Movie: " + m.getTitle());
		
		Set<Multiplex> mpexs = m.getMultiplexes();
		for (Multiplex p : mpexs) 
			System.out.println(p.getName());
	}
	
	@Test
	public void testFindMpex() {
		Multiplex m = (Multiplex) dao.findById(201, Multiplex.class);
		assertNotNull(m);
		System.out.println("Multiplex: " + m.getName());
		
		Set<Movie> movies = m.getMovies();
		for(Movie v : movies)
			System.out.println(v.getTitle());
	}
}



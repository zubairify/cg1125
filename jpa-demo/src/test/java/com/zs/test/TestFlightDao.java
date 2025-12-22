package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.FlightDao;
import com.zs.entity.Flight;
import com.zs.ext.FlightNotFoundException;

public class TestFlightDao {
	private static FlightDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new FlightDao();
	}
	
	@Test
	public void testSave() {
		Flight f = new Flight(123, "Indigo", "Mumbai", "Goa");
		assertTrue(dao.save(f));
	}
	
	@Test
	public void testFindByNo() throws FlightNotFoundException {
		Flight f = dao.findByNo(121).get();
		assertNotNull(f);
		System.out.println(f);
	}
	
	@Test
	public void testFindByNoInvalid() {
		assertThrows(FlightNotFoundException.class, () -> dao.findByNo(100));
	}
	
	@Test
	public void testAllFlights() {
		List<Flight> flights = dao.allFlights();
		assertFalse(flights.isEmpty());
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testFindByCarrier() {
		List<Flight> flights = dao.byCarrier("Indigo");
		assertFalse(flights.isEmpty());
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testFindByRoute() {
		List<Flight> flights = dao.byRoute("Mumbai", "Goa");
		assertFalse(flights.isEmpty());
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testDelete() throws FlightNotFoundException {
		assertTrue(dao.delete(121));
	}
	
	@Test
	public void testDeleteInvalid() {
		assertThrows(FlightNotFoundException.class, () -> dao.delete(100));
	}
}

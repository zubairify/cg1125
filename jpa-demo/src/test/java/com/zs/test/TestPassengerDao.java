package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.PassengerDao;
import com.zs.entity.Passenger;

public class TestPassengerDao {
	private static PassengerDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new PassengerDao();
	}
	
	@Test
	public void testSave() {
		Passenger p = new Passenger("Jack", LocalDate.of(2025, 12, 26), 3500);
		assertTrue(dao.save(p, 123));
	}
	
	@Test
	public void testFindById() {
		Passenger p = dao.findById(1);
		assertNotNull(p);
		System.out.println(p);
	}
	
	@Test
	public void testAllPassengers() {
		List<Passenger> passengers = dao.allPassenger();
		assertFalse(passengers.isEmpty());
		passengers.forEach(System.out::println);
	}
	
	@Test
	public void testItinarary() {
		List<Passenger> passengers = dao.itinarary("Mumbai", "Chennai", LocalDate.of(2025, 12, 26));
		assertFalse(passengers.isEmpty());
		passengers.forEach(System.out::println);
	}
}

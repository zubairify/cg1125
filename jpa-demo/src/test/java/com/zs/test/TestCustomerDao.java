package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.CustomerDao;
import com.zs.entity.Customer;

public class TestCustomerDao {
	private static CustomerDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new CustomerDao();
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer(121, "George", 2000);
		dao.save(c);
	}
	
	@Test
	public void testFind() {
		Customer c = dao.findById(121);
		assertNotNull(c);
	}
	
	@Test
	public void testList() {
		List<Customer> customers = dao.list();
		assertTrue(customers.size()>0);
	}
	
	@Test
	public void testDelete() {
		dao.delete(121);
	}
}

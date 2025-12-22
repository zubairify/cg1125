package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.EmpDeptDao;
import com.zs.entity.Department;
import com.zs.entity.Employee;

public class TestEmpDeptDao {
	private static EmpDeptDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new EmpDeptDao();
	}
	
	@Test
	public void testAddDept() {
		Department d = new Department(10, "Sales", "Pune");
		assertTrue(dao.addDept(d));
	}
	
	@Test
	public void testAddEmp() {
		Employee e = new Employee(101, "Polo", 2000);
		assertTrue(dao.addEmp(e, 10));
	}
	
	@Test
	public void testGetDept() {
		Department d = dao.getDept(10);
		assertNotNull(d);
		System.out.println(d);
		
		List<Employee> emps = d.getEmps();
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testGetEmp() {
		Employee e = dao.getEmp(101);
		assertNotNull(e);
		System.out.println(e);
		System.out.println(e.getDept());
	}
	
	@Test
	public void testDelDept() {
		assertTrue(dao.delDept(10));
	}
}

package com.yedam.app.di2;

import org.junit.Test;

public class ConstructorTest {

	@Test
	public void basic() {
		Employee emp = new Employee("Tony", 10293847);
		emp.setLname("Stark");
		
		System.out.println(emp.toString());
	}
}

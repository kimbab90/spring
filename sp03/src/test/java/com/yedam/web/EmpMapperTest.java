package com.yedam.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.web.mapper.EmpMapper;
import com.yedam.web.model.Employee;
import com.yedam.web.model.EmployeeSearch;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/datasource-context.xml",
		"classpath:/spring/mybatis-context.xml" })
public class EmpMapperTest {

	@Setter(onMethod_ = { @Autowired })
	private EmpMapper mapper;

	@Test
	public void test() {
		
		EmployeeSearch search = new EmployeeSearch();
		search.setDepartmentId(50);
		search.setSalary(3000);
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(139);
		ids.add(140);
		
		search.setEmployeeIds(ids);
		
		List<Employee> list = mapper.selectEmployeeAllBySearch(search);
		
		list.forEach(item -> System.out.println(item.toString()));
		
//		List<Employee> list = mapper.selectEmpolyeeAll();
//
//		for (Employee emp : list) {
//			System.out.println(emp.toString());
//		}
//
//		int count = mapper.selectEmpolyeeCount();
//
//		System.out.println("Employee Count : " + count);
//
//		List<Department> countDept = mapper.selectEmpolyeeCountGroupByDept();
//
//		countDept.forEach(item -> System.out.println(item.toString()));
//
//		Employee emp = new Employee();
//		emp.setEmployeeId(300);
//		emp.setEmail("test@test.com");
//		emp.setLastName("Belle");
//		emp.setHireDate(new Date());
//		emp.setJobId("SA_MAN");
//		
//		emp = Employee.builder()
//				.employeeId(300)
//				.email("test@test.com")
//				.lastName("Belle")
//				.hireDate(new Date())
//				.jobId("SA_MAN")
//				.build();

		// INSERT

//		int queryResult = mapper.insertEmployee(emp);
//
//		System.out.println("INSERT RESULT : " + queryResult);
//
//		Employee empOne = mapper.selectEmpolyeeOne(emp.getEmployeeId());
//
//		System.out.println(empOne.toString());

		// UPDATE

//		emp.setFirstName("Bangboo");
//
//		queryResult = mapper.updateEmployee(emp);
//
//		System.out.println("UPDATE RESULT : " + queryResult);
//
//		empOne = mapper.selectEmpolyeeOne(emp.getEmployeeId());
//
//		System.out.println(empOne.toString());

		// DELETE

//		queryResult = mapper.deleteEmployee(emp.getEmployeeId());
//
//		System.out.println("DELETE RESULT : " + queryResult);

	}

//	@Test
//	public void test2() {
//		List<Map<String, Object>> list = mapper.selectEmpolyeeAllToMap();
//
//		list.forEach(emp -> {
//			System.out.println(emp.toString());
//		});
//		
//
//		int count = mapper.selectEmpolyeeCount();
//		
//		System.out.println("Employee Count : " + count);
//	}
}

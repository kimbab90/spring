package com.yedam.web.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.web.model.Department;
import com.yedam.web.model.Employee;
import com.yedam.web.model.EmployeeSearch;

public interface EmpMapper {
	
	public List<Employee> selectEmployeeDept();

	public List<Employee> selectEmpolyeeAll();
	
	public List<Employee> selectEmployeeAllBySearch(EmployeeSearch search);
	
	public Employee selectEmpolyeeOne(int employeeId);
	
	public List<Map<String, Object>> selectEmpolyeeAllToMap();
	
	public int selectEmpolyeeCount();
	
	public List<Department> selectEmpolyeeCountGroupByDept();

	public int insertEmployee(Employee employee);
	
	public int updateEmployee(Employee employee);
	
	public int deleteEmployee(int employeeId);
	
}

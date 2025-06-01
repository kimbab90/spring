package com.yedam.hr.service;

import java.util.List;

import com.yedam.board.service.Criteria;

public interface EmployeeService {

	public List<EmployeeVO> getEmployeeSearch(Criteria criteria);
	
	public int getTotalCount(Criteria criteria);

	public EmployeeVO getEmployeeOne(int employeeId);
	
	public int postEmployee(EmployeeVO employee);
	
	public int putEmployee(EmployeeVO employee);
	
	public int deleteEmployee(int employeeId);
}

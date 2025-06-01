package com.yedam.hr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.board.service.Criteria;
import com.yedam.hr.mapper.EmployeeMapper;
import com.yedam.hr.service.EmployeeService;
import com.yedam.hr.service.EmployeeVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	final private EmployeeMapper mapper;

	@Override
	public List<EmployeeVO> getEmployeeSearch(Criteria criteria) {
		return mapper.selectEmployeeSearch(criteria);
	}

	@Override
	public int getTotalCount(Criteria criteria) {
		return mapper.getTotalCount(criteria);
	}

	@Override
	public EmployeeVO getEmployeeOne(int employeeId) {
		return mapper.selectEmployee(employeeId);
	}

	@Override
	public int postEmployee(EmployeeVO employee) {
		return mapper.insertEmployee(employee);
	}

	@Override
	public int putEmployee(EmployeeVO employee) {
		return mapper.updateEmployee(employee);
	}

	@Override
	public int deleteEmployee(int employeeId) {
		return mapper.deleteEmployee(employeeId);
	}

}

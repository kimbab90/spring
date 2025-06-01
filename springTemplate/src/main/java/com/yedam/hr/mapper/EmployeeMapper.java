package com.yedam.hr.mapper;

import java.util.List;

import com.yedam.board.service.Criteria;
import com.yedam.hr.service.EmployeeVO;

public interface EmployeeMapper {
	
	List<EmployeeVO> selectEmployeeSearch(Criteria criteria);

	int getTotalCount(Criteria criteria);

	EmployeeVO selectEmployee(int employeeId);

	int insertEmployee(EmployeeVO employee);

	int updateEmployee(EmployeeVO employee);

	int deleteEmployee(int bno);

}

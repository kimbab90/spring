package com.example.demo.mapper;

import java.util.List;

import com.example.demo.vo.EmpVO;

public interface EmpMapper {

	List<EmpVO> selectEmpAll();
	
	EmpVO selectEmpOne(int employeeId);
	
	int insertEmp(EmpVO emp);
	
	int updateEmp(EmpVO emp);
	
	int deleteEmp(int employeeId);
}

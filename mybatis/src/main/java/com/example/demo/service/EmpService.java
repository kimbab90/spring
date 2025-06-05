package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.EmpVO;

public interface EmpService {

	List<EmpVO> getEmpAll();

	EmpVO getEmpOne(int employeeId);

	int insertEmp(EmpVO emp);

	int updateEmp(EmpVO emp);

	int deleteEmp(int employeeId);
}

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.EmpService;
import com.example.demo.vo.EmpVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

	private final EmpMapper empMapper;

	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO getEmpOne(int employeeId) {
		return empMapper.selectEmpOne(employeeId);
	}

	@Override
	public int insertEmp(EmpVO emp) {
		return empMapper.insertEmp(emp);
	}

	@Override
	public int updateEmp(EmpVO emp) {
		return empMapper.updateEmp(emp);
	}

	@Override
	public int deleteEmp(int employeeId) {
		return empMapper.deleteEmp(employeeId);
	}
	
}

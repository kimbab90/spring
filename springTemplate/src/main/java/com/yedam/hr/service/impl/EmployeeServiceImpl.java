package com.yedam.hr.service.impl;

import org.springframework.stereotype.Service;

import com.yedam.hr.mapper.EmployeeMapper;
import com.yedam.hr.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	final private EmployeeMapper mapper;
	
}

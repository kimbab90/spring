package com.company.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.exam.mapper.TimeMapper;
import com.company.exam.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService {

	@Autowired TimeMapper timeMapper;
	
	public String now() {
		return timeMapper.getTime();
	}

}

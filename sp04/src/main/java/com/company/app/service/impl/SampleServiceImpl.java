package com.company.app.service.impl;

import org.springframework.stereotype.Service;

import com.company.app.service.SampleService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public String sample(String data) {
//		log.info("SampleServiceImpl called");
		return data + " return";
	}

}

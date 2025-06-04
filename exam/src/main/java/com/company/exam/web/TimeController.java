package com.company.exam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.exam.service.TimeService;

@RestController
public class TimeController {
	
	@Autowired private TimeService timeService;
	
	@GetMapping("/now")
	public String now() {
		return timeService.now();
	}
	
}

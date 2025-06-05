package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class TimeMapperTest {

	@Autowired
	TimeMapper timeMapper;
	
	
	@Test
	public void test() {
		System.out.println(timeMapper.getTime());
		System.out.println(timeMapper.getTime2());
		
	}
}

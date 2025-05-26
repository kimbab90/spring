package com.yedam.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.web.mapper.TimeMapper;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {
		"classpath:/spring/datasource-context.xml",
	    "classpath:/spring/mybatis-context.xml"
	})
public class TimeMapperTest {

	@Setter(onMethod_ = {@Autowired}) 
	private TimeMapper mapper;
	
	@Test
	public void test() {
		System.out.println(mapper.getTime());
		System.out.println(mapper.getTime2());
	}
}

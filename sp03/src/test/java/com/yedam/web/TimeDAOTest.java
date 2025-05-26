package com.yedam.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.web.dao.TimeDAO;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {
		"classpath:/spring/datasource-context.xml",
	    "classpath:/spring/mybatis-context.xml"
	})
public class TimeDAOTest {

	@Autowired
	private TimeDAO timeDAO;
	
	@Test
	public void test() {
		System.out.println(timeDAO.getTime());
	}
	
}

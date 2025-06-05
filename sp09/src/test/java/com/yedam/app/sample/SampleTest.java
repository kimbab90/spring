package com.yedam.app.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.app.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringJUnitConfig(RootConfig.class)
public class SampleTest {
	
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Test
	public void testRestraurant() {
		log.info(restaurant); 
	    log.info("---------------"); 
	    log.info(restaurant.getChef()); 
	}

}

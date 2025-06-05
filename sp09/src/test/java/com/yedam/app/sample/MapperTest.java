package com.yedam.app.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.app.config.DataSourceConfig;
import com.yedam.app.config.MyBatisConfig;
import com.yedam.app.config.RootConfig;
import com.yedam.app.mapper.TimeMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringJUnitConfig({ RootConfig.class, DataSourceConfig.class, MyBatisConfig.class })
public class MapperTest {

	@Autowired
	TimeMapper mapper;

	@Test
	public void test() {

		log.info(mapper.getTime());
		log.info(mapper.getTime2());
	}
}

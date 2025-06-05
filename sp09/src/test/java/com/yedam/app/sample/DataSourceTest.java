package com.yedam.app.sample;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.app.config.DataSourceConfig;
import com.yedam.app.config.MyBatisConfig;
import com.yedam.app.config.RootConfig;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringJUnitConfig({RootConfig.class, DataSourceConfig.class, MyBatisConfig.class})
public class DataSourceTest {

	@Autowired DataSource dataSource;
	
	@Test
	public void test() throws SQLException {
			
		Connection conn = dataSource.getConnection();
		log.info(conn);
	}
}

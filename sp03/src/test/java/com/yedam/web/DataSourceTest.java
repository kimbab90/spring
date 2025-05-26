package com.yedam.web;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:/spring/datasource-context.xml") 
public class DataSourceTest {
	
//	@Autowired
//	DataSource dataSource;
	
    @Setter(onMethod_ = {@Autowired}) 
    private DataSource dataSource; 
	
	@Test
	public void testConn() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
 	
//    @Setter(onMethod_ = {@Autowired}) 
//    private SqlSessionFactory sqlSessionFactory; 
// 
//    @Test 
//    public void testConnection() { 
//       try(Connection con = dataSource.getConnection()) { 
//           System.out.println(con); 
//      } catch(Exception e) { 
//           fail(e.getMessage()); 
//      } 
//   } 
} 

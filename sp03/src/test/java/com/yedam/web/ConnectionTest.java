package com.yedam.web;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class ConnectionTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
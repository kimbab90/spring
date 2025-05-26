package com.yedam.web.model;

import lombok.Data;

@Data
public class Department {
	
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	private int employeeCount;
}

package com.yedam.app.sp00.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmpDepts {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private String managerId;
	private int departmentId;
	
	List<Department> departments;
}

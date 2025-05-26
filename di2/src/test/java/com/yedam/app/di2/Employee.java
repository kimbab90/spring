package com.yedam.app.di2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	private final String fname;
	private String lname;
	private final int salary;
}

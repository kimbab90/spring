package com.yedam.hr.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yedam.board.service.Criteria;
import com.yedam.common.PageDTO;
import com.yedam.hr.service.EmployeeService;
import com.yedam.hr.service.EmployeeVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	final private EmployeeService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getEmployee(Criteria criteria, Model model) {

//		List<EmployeeVO> list = service.getEmployeeSearch(criteria);
//		model.addAttribute("list", list);
//
//		int total = service.getTotalCount(criteria);
//		model.addAttribute("pageMaker", new PageDTO(criteria, total));
//		
		return "employee/empList";
	}
}

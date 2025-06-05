package com.example.demo.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.EmpService;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.ResultVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {

	private final EmpService empService;
	
//	@GetMapping("/emps")
//	@ResponseBody
//	public List<EmpVO> emps() {
//		return empService.getEmpAll();
//	}
	
	@GetMapping("/emps")
	public String emps(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp";
	}
	
	@GetMapping("/emps/{employeeId}")
	@ResponseBody
	public EmpVO emps(@PathVariable("employeeId") int employeeId ) {
		return empService.getEmpOne(employeeId);
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<ResultVO> register(@RequestBody EmpVO emp) {
		ResultVO result = new ResultVO();
		
		int row = empService.insertEmp(emp);
		
		if (row > 0) {
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
	
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}

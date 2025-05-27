package com.yedam.app.sp00;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.sp00.domain.Employee;
import com.yedam.app.sp00.domain.SampleDTO;

@Controller
public class SampleController {

	@GetMapping("/ex01")
	public String ex01(SampleDTO sample, Model model) {
		System.out.println(sample);
		model.addAttribute("job", "학생");
		return "main";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam(name = "name") String name, 
						@RequestParam(name = "age", required = false, defaultValue = "10") int age) {
		return "main";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("name") List<String> names) {
		System.out.println(names);
		return "main";
	}
	
	@GetMapping("/ex03/{class}/{stdno}")
	public String ex03(@PathVariable("class") String className, @PathVariable("stdno") int stdno) {
		System.out.println(className);
		System.out.println(stdno);
		return "main";
	}
	
	@PostMapping("/ex04")
	public String ex04(@RequestBody SampleDTO sample) {
		System.out.println(sample);
		return "main";
	}
	
	@PutMapping("/ex05")
	public String ex05(@RequestBody SampleDTO sample) {
		System.out.println(sample);
		return "main";
	}
	
	@DeleteMapping("/ex06")
	public String ex06(@RequestBody SampleDTO sample) {
		System.out.println(sample);
		return "main";
	}
	
	@PostMapping("/ex07")
	public String ex07(@RequestBody List<Employee> employee) {
//		System.out.println(employee);
		employee.forEach(item -> System.out.println(item));
		return "main";
	}
}

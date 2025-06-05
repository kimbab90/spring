package com.yedam.app.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.service.SampleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SampleController {

	private final SampleService sampleService;

	@GetMapping("/time")
	@ResponseBody
	public String time() {
		return sampleService.getTime();
	}

	@GetMapping("/time2")
	public String time2(Model model) {
		String now = sampleService.getTime2();
		model.addAttribute("now", now);
		return "home";
	}
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	
	@PostMapping("/uploadFormAction")
	public String uploadFormAction(
			@RequestPart("uploadFile") MultipartFile uploadFile,
			@RequestParam("desc") String desc) throws IllegalStateException, IOException {
		System.out.println(desc);
		System.out.println(uploadFile.getSize());
		System.out.println(uploadFile.getOriginalFilename());
		uploadFile.transferTo(new File("c:/upload", uploadFile.getOriginalFilename()));
		return "uploadForm";
	}
}

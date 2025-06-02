package com.company.app.web;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.app.service.SampleService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class SampleController {

	private final SampleService service;

	@RequestMapping(value = "/sampleList", method = RequestMethod.GET)
	public String sampleList(Locale locale, Model model) {
		List<SampleVO> list = IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "fisrt", i + "last"))
				.collect(Collectors.toList());
		model.addAttribute("list", list);
		return "home";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		int i = 5 / 0;
		return "home";
	}

	@RequestMapping(value = "/aop", method = RequestMethod.GET)
	public String aop(@RequestParam("data") String data) {
		service.sample(data);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@GetMapping({ "/all", "/member", "/admin", "/accessError", "/customLogin" })
	public void all(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
	}

//	@RequestMapping(value = "/sampleMap", method = RequestMethod.GET)
//	public Map<String, SampleVO> sampleMap(Locale locale, Model model) {
//		Map<String, SampleVO> map = new HashMap<>();
//		map.put("mapmap", new SampleVO(1, "AA", "BB"));
//		return map;
//	}
}

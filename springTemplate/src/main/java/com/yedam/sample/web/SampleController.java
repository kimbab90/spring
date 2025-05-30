package com.yedam.sample.web;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
public class SampleController {
	
//    private final TimeService timeService;
	
	@RequestMapping(value = "/sampleList", method = RequestMethod.GET)
	public List<SampleVO> sampleList(Locale locale, Model model) {
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"fisrt", i+"last")).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/sampleMap", method = RequestMethod.GET)
	public Map<String, SampleVO> sampleMap(Locale locale, Model model) {
		Map<String, SampleVO> map = new HashMap<>();
		map.put("mapmap", new SampleVO(1, "AA", "BB"));
		return map;
	}
}

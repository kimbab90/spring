package com.company.app.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.mapper.Sample1Mapper;
import com.company.app.mapper.Sample2Mapper;
import com.company.app.service.SampleTxService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleTxServiceImpl implements SampleTxService {

	private final Sample1Mapper mapper1;
	private final Sample2Mapper mapper2;

	@Override
	public int sample1(String data) {
		return mapper1.insertCol1(data);
	}

	@Override
	public int sample2(String data) {
		return mapper2.insertCol2(data);
	}

	@Transactional
	@Override
	public int sample(String data) {
		int result1 = mapper1.insertCol1(data);
		int result2 = mapper2.insertCol2(data);
		return result1 + result2;
	}

}

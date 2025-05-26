package com.yedam.app.di2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yedam.app.annotation.AppleSpeaker;
import com.yedam.app.annotation.LgTV;
import com.yedam.app.annotation.Speaker;
import com.yedam.app.annotation.TV;

@Configuration
public class ContextConfigure {

	@Bean
	public Speaker speaker() {
		return new AppleSpeaker();
	}
	
	@Bean
	public TV tv() {
		LgTV tv = new LgTV();
		tv.setSpeaker(speaker());
		return tv;
//		return new SamsungTV(speaker());
	}
}

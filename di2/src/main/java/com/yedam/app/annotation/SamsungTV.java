package com.yedam.app.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
//@AllArgsConstructor
@Component("sstv")
public class SamsungTV implements TV {

//	@Qualifier("sspeaker")
	private Speaker speaker;

	public SamsungTV(@Qualifier("sspeaker") Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}

	public void powerOff() {
		System.out.println("SamsungTV powerOff");
	}

	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");
		speaker.volumeUp();
	}

	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");
		speaker.volumeDown();
	}

}

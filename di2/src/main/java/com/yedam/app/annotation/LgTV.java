package com.yedam.app.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Component("lgtv")
public class LgTV implements TV {

	@Setter(onMethod_ = { @Autowired, @Qualifier("aspeaker") })
	private Speaker speaker;

	public LgTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("===> LgTV");
	}

	public LgTV() {
		System.out.println("===> LgTV");
	}

	public void powerOn() {
		System.out.println("LgTV powerOn.");
	}

	public void powerOff() {
		System.out.println("LgTV powerOff.");
	}

	public void volumeUp() {
		System.out.println("LgTV volumeUp.");
		speaker.volumeUp();
	}

	public void volumeDown() {
		System.out.println("LgTV volumeDown.");
		speaker.volumeDown();
	}

}

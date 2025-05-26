package com.yedam.app.annotation;

import org.springframework.stereotype.Component;

@Component("sspeaker")
public class SonySpeaker implements Speaker {
    public SonySpeaker() {
        System.out.println("=== SonySpeaker ====");
    }    
    public void volumeUp() {
        System.out.println("SonySpeaker volumeUp.");
    }
    public void volumeDown() {
        System.out.println("SonySpeaker volumeDown.");
    }

}

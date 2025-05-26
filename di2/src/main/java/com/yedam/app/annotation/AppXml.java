package com.yedam.app.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yedam.app.di2.ContextConfigure;

public class AppXml {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//    	ApplicationContext context = new ClassPathXmlApplicationContext("annotationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigure.class);

		TV tv = (TV) context.getBean("lgtv");

		tv.powerOn();

		tv.volumeUp();

		tv = (TV) context.getBean("sstv");

		tv.powerOn();

		tv.volumeUp();
	}
}
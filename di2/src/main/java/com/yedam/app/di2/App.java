package com.yedam.app.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yedam.app.annotation.TV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
//    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfigure.class);
    	
    	TV tv = (TV) context.getBean("tv");
    	
    	tv.powerOn();
    	
    	tv.volumeUp();
    	
//    	TV tv = (TV) context.getBean("tv2");
//    	
//    	tv.powerOn();
//    	
//    	tv.volumeUp();
//    	
//    	tv = (TV) context.getBean("tv3");
//    	
//    	tv.powerOn();
//    	
//    	tv.volumeUp();
    	
    	
//        LgTV ltv = new LgTV();
//        ltv.powerOn();
//        ltv.volumeUp();
//        
//        TV tv = new LgTV();
//        
//        tv.powerOn();
//        
//        tv = new SamsungTV();
//        
//        tv.powerOn();
    }
}

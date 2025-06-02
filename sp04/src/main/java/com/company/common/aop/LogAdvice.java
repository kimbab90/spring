package com.company.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Component
public class LogAdvice {

	@Pointcut("execution(* com.company..*Impl.*(..))")
	public void allpointcut() {
	}

	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		log.info("[Before]" + methodName);

		Object[] args = jp.getArgs();

		if (args != null && args.length > 0) {
			for (Object item : args) {
				log.info("[Before Param]" + item.toString());
			}
		}
	}

	@AfterReturning("allpointcut()")
//	@After
//	@AfterThrowing
	public void AfterReturn(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		log.info("[After]" + methodName);

		Object[] args = jp.getArgs();

		if (args != null && args.length > 0) {
			for (Object item : args) {
				log.info("[After Param]" + item.toString());
			}
		}
	}

	@Around("execution(* com.company..*Impl.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();

		log.info("target : " + pjp.getTarget());
		log.info("param : " + Arrays.toString(pjp.getArgs()));

		Object result = null;

		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		log.info("time : " + (end - start));

		return result;
	}
}

package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	
	@Before("within(com.revature.controllers.*.*)")
	public void logControllerMethods(JoinPoint jp) {
		System.out.println("hitting logControllerMethods() in LoggingAspect class");
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	@AfterReturning(pointcut = "execution(* findByState(..))", returning = "returnedObject")
	public void logAllReturned(JoinPoint jp, Object returnedObject) {
		System.out.println("hitting logAllReturned() in LoggingAspect");
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@Before("allMethodsPointcut()")
	public void allControllerMethodsAdvice(JoinPoint jp){
		System.out.println("Before executing controller method");
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	//Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(com.revature.controllers.*)")
	public void allMethodsPointcut(){}
	
}

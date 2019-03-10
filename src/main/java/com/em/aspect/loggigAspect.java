package com.em.aspect;

import java.util.Arrays;

import javax.sql.rowset.Joinable;
import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class loggigAspect {
	
	Logger logger = Logger.getLogger(this.getClass());

	@Pointcut("within(com.em.controller..*) ")
	void withinMyChoice() {
	}

	@Around("withinMyChoice()")
	public Object Advice(ProceedingJoinPoint join) throws Throwable {
		Signature signature = join.getSignature();
		String name = signature.getName(); 
		String args = Arrays.toString(join.getArgs());
		Object proceed = join.proceed();
		logger.info(signature+" args ->"+args+ " result->"+proceed );
		return join.proceed();
	}

	
}

package com.solvay.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogUtil {

    @Pointcut("execution( * com.solvay.spring.aspect.*(..))")
    public void logPointCut(){}

    @Before("logPointCut()")
    public void logStart(JoinPoint joinPoint){
        joinPoint.getSignature().getName();
    }

    @After("logPointCut()")
    public void logEnd(JoinPoint joinPoint){
        joinPoint.getSignature().getName();
    }

    @AfterReturning(value = "logPointCut()")
    public void logResult(JoinPoint joinPoint){

    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        Object result = proceedingJoinPoint.proceed(args);
        return result;
    }
}

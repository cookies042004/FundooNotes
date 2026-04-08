package com.example.FundoNotesApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.FundoNotesApp.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entering: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.example.FundoNotesApp.service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Exiting: " + joinPoint.getSignature());
        System.out.println("Result: " + result);
    }
}

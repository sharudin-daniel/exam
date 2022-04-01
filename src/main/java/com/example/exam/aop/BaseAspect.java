package com.example.exam.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class BaseAspect {

//    @Pointcut("execution(* com.example.exam.controller.GoodController.*())")
//    public void logging() {
//    }
//
//    @Before("logging()")
//    public void beforeAdvice(JoinPoint joinPoint) {
//        System.out.println("dssssssssssssssss");
////        log.info(joinPoint.getSignature().getName());
//    }

//    @Pointcut("within(com.example.exam.controller.*)")
//    public void stringProcessingMethods() {
//    };
//
//    @After("stringProcessingMethods()")
//    public void logMethodCall(JoinPoint jp) {
//        log.info(jp.getSignature().toString());
//    }
}

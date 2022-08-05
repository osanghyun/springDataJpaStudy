package com.kt.springdemodatajpa.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class ControllerLoggingAspect {
    @Pointcut("execution(* com.kt.springdemodatajpa.controller..*.*(..))")
    private void all(){}

    @Pointcut("execution(* com.kt.springdemodatajpa.controller.UserController.*(..))")
    private void thyme(){}

    @Before("all()")
    public void beforeParameterLog(JoinPoint joinPoint) {
        Method method = getMethod(joinPoint);
        log.info("======= Controller Method Name = {} =======", method.getName());

        Object[] args = joinPoint.getArgs();
        if (args.length <= 0) log.info("no parameter");
        for (Object arg : args) {
            log.info("parameter type = {}", arg.getClass().getSimpleName());
            log.info("parameter value = {}", arg);
        }
    }

    @AfterReturning(value = "thyme()", returning = "returnObj")
    public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.info("======= Controller Method Name = {} =======", method.getName());
        log.info("return type = {}", returnObj.getClass().getSimpleName());
        log.info("return value = {}", returnObj);
    }

    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }



}

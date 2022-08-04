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


    // com.kt.springdemodatajpa.controller 이하 패키지의 모든 클래스 이하 모든 메서드에 적용
    // 파라미터가 몇개가 존재하던지 상관없이 적용.
    // 반환형도 상관없이 적용.
    @Pointcut("execution(* com.kt.springdemodatajpa.controller..*.*(..))")
    private void all(){}

    @Pointcut("execution(* com.kt.springdemodatajpa.controller.UserController.*(..))")
    private void thyme(){}

    // Pointcut에 의해 필터링된 경로로 들어오는 경우 메서드 호출 전에 적용
    @Before("all()")
    public void beforeParameterLog(JoinPoint joinPoint) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.info("======= Controller Method Name = {} =======", method.getName());

        // 파라미터 받아오기
        Object[] args = joinPoint.getArgs();
        if (args.length <= 0) log.info("no parameter");
        for (Object arg : args) {
            log.info("parameter type = {}", arg.getClass().getSimpleName());
            log.info("parameter value = {}", arg);
        }
    }

    // Poincut에 의해 필터링된 경로로 들어오는 경우 메서드 리턴 후에 적용
    @AfterReturning(value = "thyme()", returning = "returnObj")
    public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.info("======= Controller Method Name = {} =======", method.getName());
        log.info("return type = {}", returnObj.getClass().getSimpleName());
        log.info("return value = {}", returnObj);
    }

    // JoinPoint로 메서드 정보 가져오기
    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }



}

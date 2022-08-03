package com.kt.springdemodatajpa.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
@Aspect
@Slf4j
public class ExceptionLoggingAspect {
    // com.kt.springdemodatajpa.controller 이하 패키지의 모든 클래스 이하 모든 메서드에 적용
    // 파라미터가 몇개가 존재하던지 상관없이 적용.
    // 반환형도 상관없이 적용.
    @Pointcut("execution(* com.kt.springdemodatajpa.exception.ControllerExceptionHandler.*(..))")
    private void cut(){}

    // Poincut에 의해 필터링된 경로로 들어오는 경우 메서드 리턴 후에 적용
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
        // 메서드 정보 받아오기
        Method method = getMethod(joinPoint);
        log.info("======= Exception method name = {} =======", method.getName());
        log.info("{}", returnObj);
    }

    // JoinPoint로 메서드 정보 가져오기
    private Method getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}

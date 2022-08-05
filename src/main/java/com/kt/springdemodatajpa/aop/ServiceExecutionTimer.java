package com.kt.springdemodatajpa.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


// todo proxy pattern 공부.
// todo stateless, sticky session
// todo delete, update query auto commit 하면 안됨.
@Slf4j
@Aspect
@Component
public class ServiceExecutionTimer {

    // 조인 포인트 설정.
    @Pointcut("execution(* com.kt.springdemodatajpa.service..*.*(..))")
    private void timer(){}

    // 메서드 실행 전, 후로 수행
    @Around("timer()")
    public Object AssumeExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        try {
            return joinPoint.proceed(); // 조인 포인트의 메서드 실행
        } finally {
            stopWatch.stop();

            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String methodName = signature.getMethod().getName();

            log.info("실행 메서드: {}, 실행시간 = {}ms", methodName, stopWatch.getTotalTimeMillis());
        }
    }
}

package com.youngman.springaopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by youngman on 2018-12-23.
 * 해야할일 : Advice
 * 어디에 적용할 것인가 : 포인트컷
 */
@Component
@Aspect//Aspect Class 명시
public class PerfAspect {
    Logger logger = LoggerFactory.getLogger(PerfAspect.class);

    @Around("execution(* com.youngman..*.EventService.*(..))")//포인트 컷, com.youngman 으로 시작하는 패키지에서 EventService에 있는 모든 메서드에 아래 행위를 적용한다
    //@Around("@annotation(PerLogging)")//해당 어노테이션이 메소드에만 적용 된다.
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    //메소드 시작 전에 적용
    @Before("bean(simpleEventService)")
    public void hello() {
        //logger.info("hello");
        System.out.println("=================hello====================");
    }

    //메소드 끝난 후 적용
    @After("bean(simpleEventService)")
    public void bye() {
        //logger.info("hello");
        System.out.println("==================bye====================");
    }
}

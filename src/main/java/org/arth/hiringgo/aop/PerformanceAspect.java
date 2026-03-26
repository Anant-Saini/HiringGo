package org.arth.hiringgo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* org.arth.hiringgo.service.JobService.*(..))")
    public Object calculateDuration(ProceedingJoinPoint pjp) throws Throwable {

        Long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        Long end = System.currentTimeMillis();
        LOGGER.info("Time take by {} is: {}ms", pjp.getSignature().getName(), end - start);
        return obj;
    }
}

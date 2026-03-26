package org.arth.hiringgo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // execution() ---> return type, complete-class-name-with-package, method name, args
    @Before("execution(* org.arth.hiringgo.service.JobService.*(..)) ||" +
            "execution(* org.arth.hiringgo.repository.JobRepo.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("method called: {}", jp.getSignature());
    }

    @After("execution(* org.arth.hiringgo.service.JobService.*(..)) ||" +
            "execution(* org.arth.hiringgo.repository.JobRepo.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("method executed: {}", jp.getSignature().getName());
    }

    @AfterThrowing("execution(* org.arth.hiringgo.service.JobService.*(..)) ||" +
            "execution(* org.arth.hiringgo.repository.JobRepo.*(..))")
    public void logMethodCrashes(JoinPoint jp) {
        LOGGER.info("method {} throws an exception", jp.getSignature().getName());
    }

    @AfterReturning("execution(* org.arth.hiringgo.service.JobService.*(..)) ||" +
            "execution(* org.arth.hiringgo.repository.JobRepo.*(..))")
    public void logMethodSuccessful(JoinPoint jp) {
        LOGGER.info("method {} is successful!", jp.getSignature().getName());
    }
}

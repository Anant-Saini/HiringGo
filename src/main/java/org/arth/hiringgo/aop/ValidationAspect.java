package org.arth.hiringgo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* org.arth.hiringgo.service.JobService.getJobPost(..)) && args(postId)")
    public Object validateAndUpdateGetJobPostInput(ProceedingJoinPoint pjp, int postId) throws Throwable {

        if(postId < 0) {
            LOGGER.info("Post Id is negative.");
            postId = Math.abs(postId);
            LOGGER.info("New Post Id is {}", postId);
        }

        return pjp.proceed(new Object[]{postId});
    }
}

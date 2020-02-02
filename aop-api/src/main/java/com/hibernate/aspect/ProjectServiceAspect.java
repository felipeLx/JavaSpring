package com.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ProjectServiceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceAspect.class);

    @Before("execution(* com.hibernate.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        LOG.info("Searching Project with Id {}", joinPoint.getArgs()[0]);
    }

}
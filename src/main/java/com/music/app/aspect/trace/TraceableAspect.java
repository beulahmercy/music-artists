package com.music.app.aspect.trace;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class TraceableAspect {

    Logger logger = LoggerFactory.getLogger(TraceableAspect.class);
 
    @Around("@annotation(Traceable)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
 
        logger.info("Input : {}", joinPoint.getArgs()[0]);
 
        //HttpServletRequest servletRequest = (HttpServletRequest) joinPoint.getArgs()[1];

        //logger.info("Remote Address {}", servletRequest.getRemoteAddr());
 
        Object result = joinPoint.proceed();

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();

        try {

            // get Organisation object as a json string
            String jsonStr = Obj.writeValueAsString(result);

            // Displaying JSON String
            logger.info("result {}", jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
 
}
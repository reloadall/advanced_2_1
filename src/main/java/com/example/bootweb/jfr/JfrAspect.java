package com.example.bootweb.jfr;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class JfrAspect {

    @Around("@annotation(JfrRequest)")
    public Object jfrRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        JfrRequestEvent event = new JfrRequestEvent();
        if (!event.isEnabled()) {
            return joinPoint.proceed();
        }

        final HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        event.method = request.getMethod();
        event.url = request.getRequestURI();
        event.size = request.getContentLengthLong();

        event.begin();

        Object proceed = joinPoint.proceed();

        event.end();
        event.commit();
        return proceed;
    }
}

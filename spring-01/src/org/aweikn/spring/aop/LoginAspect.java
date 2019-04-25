package org.aweikn.spring.aop;// 2019/4/24

import org.aspectj.lang.ProceedingJoinPoint;


public class LoginAspect {

    public Object loginAspects(ProceedingJoinPoint joinPoint) throws  Throwable {
        System.out.println("start loginAspect ." + joinPoint.getSignature().getName());
        Object obj = joinPoint.proceed();
        System.out.println("end loginAspect ." + joinPoint.getSignature().getName());
        return  obj;
    }
}

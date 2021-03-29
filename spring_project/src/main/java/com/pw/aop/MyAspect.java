package com.pw.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author pengwei
 * @date 2021/2/17
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution(com.pw.aop.AopServiceImpl.*(..)")
    public void before(){
        System.out.println("******** @Before我是前置通知");
    }
    //@After
    //@AfterReturning
    //@AfterThrowing
    //@Around


}

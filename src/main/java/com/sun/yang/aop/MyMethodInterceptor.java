package com.sun.yang.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @ClassName MyMethodInterceptor
 * @Description 拦截器
 * @Author Administrator
 * @Date 2021/12/31
 **/
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(getClass()+"调用方法前");
        Object ret=methodInvocation.proceed();
        System.out.println(getClass()+"调用方法后");
        return ret;
    }
}

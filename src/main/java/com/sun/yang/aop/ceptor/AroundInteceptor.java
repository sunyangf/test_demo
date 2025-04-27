package com.sun.yang.aop.ceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundInteceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.err.println(methodInvocation.getMethod().getName() + "调用之前");
        Object res = methodInvocation.proceed();
        System.err.println(methodInvocation.getMethod().getName() + "调用之后");
        return res;
    }
}

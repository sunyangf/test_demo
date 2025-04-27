package com.sun.yang.aop;

import com.sun.yang.aop.ceptor.AroundInteceptor;
import com.sun.yang.service.impl.UserServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

public class SpringAopTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(new UserServiceImpl());
        proxyFactory.addAdvice(new AroundInteceptor());
        UserServiceImpl proxy = (UserServiceImpl) proxyFactory.getProxy();
        proxy.print();
        System.err.println(proxy.getClass().getName());
    }
}

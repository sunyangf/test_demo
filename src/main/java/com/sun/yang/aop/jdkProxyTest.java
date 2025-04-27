package com.sun.yang.aop;

import com.sun.yang.aop.proxy.ProxyFactory;
import com.sun.yang.service.UserService;
import com.sun.yang.service.impl.UserServiceImpl;

public class jdkProxyTest {
    public static void main(String[] args) {
        UserService target=new UserServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        UserService proxyInstance = (UserService) proxyFactory.getProxyInstance();
        proxyInstance.print();
    }
}

package com.sun.yang.aop;

import com.sun.yang.aop.proxy.CglibProxyFactory;
import com.sun.yang.service.UserService;
import com.sun.yang.service.impl.UserServiceImpl;

public class CglibProxyTest {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(userService);
        UserService proxyInstance = (UserService) cglibProxyFactory.getProxyInstance();
        proxyInstance.print();
    }
}

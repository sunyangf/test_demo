package com.sun.yang.service.impl;

import com.sun.yang.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/31
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void print() {
        System.out.println(getClass()+"#print");
    }
}

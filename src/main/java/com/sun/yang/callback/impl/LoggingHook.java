package com.sun.yang.callback.impl;

import com.sun.yang.callback.Hook;

public class LoggingHook extends Hook{
    @Override
    public void before() {
        System.out.println("Before calculation");
    }

    @Override
    public void after() {
        System.out.println("After calculation");
    }
}

package com.sun.yang.callback.impl;

import com.sun.yang.callback.service.CallBackService;

public class CallBackServiceImpl implements CallBackService {
    @Override
    public void execute() {
        System.out.println("执行固定回调！！！");
    }
}

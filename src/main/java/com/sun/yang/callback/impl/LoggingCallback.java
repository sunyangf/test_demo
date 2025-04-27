package com.sun.yang.callback.impl;

import com.sun.yang.callback.service.CallBack;

public class LoggingCallback implements CallBack{
    @Override
    public void onResult(int result) {
        System.out.println("Result: " + result);
    }
}

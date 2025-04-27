package com.sun.yang.callback;

import com.sun.yang.callback.service.CallBack;

public class Calculator {
    public void add(int a, int b, CallBack callback) {
        int result = a + b;
        callback.onResult(result);
    }
    public int add(int a, int b, Hook hook) {
        hook.before();
        int result = a + b;
        hook.after();
        return result;
    }

}

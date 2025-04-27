package com.sun.yang.callback;

import com.sun.yang.callback.impl.CallBackServiceImpl;
import com.sun.yang.callback.service.CallBackService;

public class CallBackMainTest {
    public static void main(String[] args) {
        MainBusiness mainBusiness = new MainBusiness();
        mainBusiness.doMainBusiness(new CallBackServiceImpl());

        mainBusiness.doMainBusiness(new CallBackService() {
            @Override
            public void execute() {
                System.out.println("执行自定义回调！！");
            }
        });
    }
}

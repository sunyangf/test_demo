package com.sun.yang.callback;

/**
 * @ClassName Caller
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class Caller {
    public void call(ICallBack callBack) {
        System.out.println("Start...");
        callBack.callBack();
        System.out.println("End...");
    }

}

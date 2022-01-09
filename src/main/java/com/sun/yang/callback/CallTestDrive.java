package com.sun.yang.callback;

/**
 * @ClassName CallTestDrive
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class CallTestDrive {
    public static void main(String[] args) {
        Caller call = new Caller();

        ICallBack callBack = new ICallBack() {
            @Override
            public void callBack() {
                // TODO Auto-generated method stub
                System.out.println("回调函数回调成功!");
            }
        };
        call.call(callBack);
    }

}

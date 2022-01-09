package com.sun.yang.callback;

/**
 * @ClassName MainBusiness
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class MainBusiness {
    private CallbackService callback;

    public void execute(CallbackService callback) {
        this.callback = callback;
        callBack();
    }

    public void callBack() {
        callback.callBackFunc();
    }
}

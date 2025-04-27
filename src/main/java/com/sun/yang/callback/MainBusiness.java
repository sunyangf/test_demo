package com.sun.yang.callback;

import com.sun.yang.callback.service.CallBackService;

public class MainBusiness {
    private CallBackService service;

    public void doMainBusiness(CallBackService service){
        this.service = service;
        callBack();
    }
    public void callBack() {
        service.execute();
    }

}

package com.sun.yang.callback.service.handler;

import com.sun.yang.callback.service.CallBackInterface;

import java.util.ArrayList;
import java.util.List;

public class WorldListHandler {
    List<String> stringList = new ArrayList<>();
    public void execute(CallBackInterface callBackInterface){
        Object process = callBackInterface.process(stringList);
        System.out.println(process);
    }


    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}

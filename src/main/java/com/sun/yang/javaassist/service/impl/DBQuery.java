package com.sun.yang.javaassist.service.impl;

import com.sun.yang.javaassist.service.IDBQuery;

/**
 * @ClassName DBQuery
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/19
 **/
public class DBQuery implements IDBQuery {
    public DBQuery(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        System.out.println("request String");
        return "request String";
    }

    @Override
    public String say() {
        return null;
    }
}

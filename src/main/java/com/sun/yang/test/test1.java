package com.sun.yang.test;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @ClassName test1
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/21
 **/
public class test1 {
    public static void main(String[] args) {
        Date d1=new Date();
        Date d2 =new Date();
        System.out.println(d1.getTime());
        System.out.println(d2.getTime());
        System.out.println(d1.getTime()==d2.getTime());

    }
}

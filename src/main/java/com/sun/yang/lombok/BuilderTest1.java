package com.sun.yang.lombok;

import com.sun.yang.pojo.UserInfo;

/**
 * @ClassName LombokTest1
 * @Description TODO
 * @Author Administrator
 * @Date 2022/1/7
 **/
public class BuilderTest1 {
    public static void main(String[] args) {
        UserInfo userInfo= UserInfo.builder().name("test").email("1213@yonyou,com").build();
        System.out.println(userInfo.getName());
        System.out.println(userInfo.toString());

    }
}

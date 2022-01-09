package com.sun.yang.classloader;

import jodd.util.URLDecoder;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/14
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {
        String LOCATION = "";
        String URLLOCATION = "";
        LOCATION = ClassLoaderTest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        URLLOCATION =  URLDecoder.decode(LOCATION, "UTF-8");
        System.out.println("Loc=" + LOCATION);
        System.out.println("URLLoc=" + URLLOCATION);
    }
}

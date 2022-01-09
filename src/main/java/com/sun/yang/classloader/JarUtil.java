package com.sun.yang.classloader;


import java.net.URL;
import java.net.URLClassLoader;

/**
 * @ClassName JarUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/22
 **/
public class JarUtil extends URLClassLoader {
    public JarUtil(URL url) {
        super(new URL[]{url});
    }

}

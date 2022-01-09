package com.sun.yang.compress;

import com.sun.yang.classloader.JarUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * @ClassName eadJarClass
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/22
 **/
public class ReadJarClass extends URLClassLoader {
    public ReadJarClass(URL url) {
        super(new URL[]{url});
    }

    public static void main(String[] args) {
        String filePath = "D:\\work_test\\test_demo\\target\\test_demo-1.0-SNAPSHOT.jar";
        URL url = null;
        try {
            url = new URL("file:///"+filePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ReadJarClass read = new ReadJarClass(url);
        try (JarFile jarfile = new JarFile(filePath)) {
            Enumeration<JarEntry> entries = jarfile.entries();
            StringBuffer classStr = new StringBuffer();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                if (jarEntry.getName().endsWith("Aclass.class")) {
                    String classFullName = jarEntry.getName();
                    //去掉后缀.class
                    String className = classFullName.substring(0, classFullName.length() - 6).replace("/", ".");
                    System.out.println("~~~~~~~~~~~~~~~Class名称：" + className);

                    Class c = null;
                    try {
                        c = read.findClass(className);
                    } catch (LinkageError e) {
                        c = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Constructor[] constructors = c.getConstructors();
                    for(Constructor constructor:constructors){
                        System.out.println("构造函数："+constructor.getName());
                        System.out.println("构造函数参数："+ Arrays.stream(constructor.getParameterTypes()).collect(Collectors.toList()));
                        System.out.println("1111: "+constructor.toString());
                    }
                    //通过getMethod得到类中包含的方法
                    Method methods[] = c.getMethods();
                    for (Method method : methods) {
                        String sm = method.getName();
                        System.out.println("方法名："+sm);
//                        //打印除默认方法外的方法
//                        if ("getTTT".contains(sm)) {
//                            System.out.println("11:"+method.toString());
//                            System.out.println("方法名：" + sm);
//                        }

                    }
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

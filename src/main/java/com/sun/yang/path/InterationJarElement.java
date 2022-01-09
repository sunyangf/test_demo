package com.sun.yang.path;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @ClassName InterationJarElement
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/25
 **/
public class InterationJarElement {
    public static void main(String[] args) {
        String path="D:/work/iuap-boot-starter-example/iuap-boot-starter-example-consumer/target/iuap-boot-starter-example-consumer-2.1.0-RELEASE-module.war";
        try {
            JarFile jarfile = new JarFile(path);
            Enumeration<JarEntry> entries = jarfile.entries();
            while (entries.hasMoreElements()){
                JarEntry jarEntry = entries.nextElement();
                if (jarEntry.getName().endsWith(".jar")) {
                    System.out.println(jarEntry.getName());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

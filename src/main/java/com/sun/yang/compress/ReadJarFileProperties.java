package com.sun.yang.compress;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @ClassName ReadJarFileProperties
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/20
 **/
public class ReadJarFileProperties {
    public static void main(String[] args) {
        String filePath = "D:\\worjktest\\2.1.0-RELEASE1\\modules\\iuap-apcom-event\\iuap-apcom-event-module\\WEB-INF\\lib\\druid-1.1.21.jar";
        try (JarFile jarfile = new JarFile(filePath)) {
            Enumeration<JarEntry> entries = jarfile.entries();
            StringBuffer classStr = new StringBuffer();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                if (jarEntry.getName().endsWith("pom.properties")) {
                    InputStream input = jarfile.getInputStream(jarEntry);//读入需要的文件
                    readFile(input);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFile(InputStream input) throws IOException {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

}

package com.sun.yang.compress;

import com.yonyou.iuap.yms.alarm.Constant;

import java.io.File;

/**
 * @ClassName ReadFileJar
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/20
 **/
public class ReadFileJar {
    public static void main(String[] args) {
        String filePath="D:\\worjktest\\2.1.0-RELEASE1\\modules\\iuap-apcom-event\\iuap-apcom-event-module\\WEB-INF\\lib";
        try {
            File targetFile = new File(filePath);
            File[] files = targetFile.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(".jar")) {
                    System.out.println("fileName:"+file.getName());
                    System.out.println("filePath:"+file.getPath());
                    System.out.println("AbsolutePath:"+file.getAbsolutePath());
                }
            }
        } catch (NoSuchFieldError e) {
            e.printStackTrace();
        }

    }
}

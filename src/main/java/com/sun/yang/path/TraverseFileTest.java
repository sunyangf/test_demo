package com.sun.yang.path;

import java.io.File;

/**
 * @ClassName TraverseFileTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/14
 **/
public class TraverseFileTest {
    public static void main(String[] args) {
        File file=new File("C:/Users/Administrator/.yms/home/8080/webapps/consumer/WEB-INF/classes/com");
        filesDirs(file);
    }

    //使用递归遍历文件夹及子文件夹中文件
    public static void filesDirs(File file){
        if(file!=null){
            if(file.isDirectory()){
                File[] files=file.listFiles();
                for (File flies2:files) {
                    filesDirs(flies2);
                }
            }else{
                if(file.getName().endsWith(".class")){
                    System.out.println("文件名字"+file);
                }
            }
        }else{
            System.out.println("文件不存在");

        }
    }
}

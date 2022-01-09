package com.sun.yang.compress;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * @ClassName ReadAssignPathJar
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/10
 **/
public class ReadAssignPathJar {
    public static void main(String[] args) throws IOException {
//        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(ResourceUtils.CLASSPATH_URL_PREFIX + "META-INF/folder/**/*.txt");
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("D:/worjktest/2.2.0-SNAPSHOT/external/lib/*.jar");
        for(Resource resource:resources){
            System.out.println(resource.getFilename());
        }

    }

//    public static void readAllFile(String filepath) {
//        File file= new File(filepath);
//        if(!file.isDirectory()){
//            listname.add(file.getName());
//        }else if(file.isDirectory()){
//            System.out.println("文件");
//            String[] filelist=file.list();
//            for(int i = 0;i<filelist.length;i++){
//                File readfile = new File(filepath);
//                if (!readfile.isDirectory()) {
//                    listname.add(readfile.getName());
//                } else if (readfile.isDirectory()) {
//                    readAllFile(filepath + "\\" + filelist[i]);//递归
//                }
//            }
//        }
//        for(int i = 0;i<listname.size();i++){
//            System.out.println(listname.get(i));
//        }
//    }



}

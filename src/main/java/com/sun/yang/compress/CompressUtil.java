package com.sun.yang.compress;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName CompressUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/30
 **/
public class CompressUtil {
    public static String writeStr="111111111111111111,22222222222222222222,33333333333333333333333,444444444444444444,55555555555555555";
    /**
     * @param path   要压缩的文件路径
     * @param format 生成的格式（zip、rar）d
     */
    public static File generateFile(String path, String format) throws Exception {

        File file = new File(path);
        // 压缩文件的路径不存在
        if (!file.exists()) {
           //创建压缩文件：
            fileLinesWrite(path,writeStr,false);
        }
        // 用于存放压缩文件的文件夹
        String generateFile = file.getParent() + File.separator +"CompressFile";
        File compress = new File(generateFile);
        // 如果文件夹不存在，进行创建
        if( !compress.exists() ){
            compress.mkdirs();
        }

        // 目的压缩文件
        String generateFileName = compress.getAbsolutePath() + File.separator + "AAA" + file.getName() + "." + format;

        // 输入流 表示从一个源读取数据
        // 输出流 表示向一个目标写入数据

        // 输出流
        FileOutputStream outputStream = new FileOutputStream(generateFileName);

        // 压缩输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream));

        generateFile(zipOutputStream,file,"");

        System.out.println("源文件位置：" + file.getAbsolutePath() + "，目的压缩文件生成位置：" + generateFileName);
        // 关闭 输出流
        zipOutputStream.close();
        return file;
    }
    /**
     * @param out  输出流
     * @param file 目标文件
     * @param dir  文件夹
     * @throws Exception
     */
    private static void generateFile(ZipOutputStream out, File file, String dir) throws Exception {

        // 当前的是文件夹，则进行一步处理
        if (file.isDirectory()) {
            //得到文件列表信息
            File[] files = file.listFiles();

            //将文件夹添加到下一级打包目录
            out.putNextEntry(new ZipEntry(dir + "/"));

            dir = dir.length() == 0 ? "" : dir + "/";

            //循环将文件夹中的文件打包
            for (int i = 0; i < files.length; i++) {
                generateFile(out, files[i], dir + files[i].getName());
            }

        } else { // 当前是文件

            // 输入流
            FileInputStream inputStream = new FileInputStream(file);
            // 标记要打包的条目
            out.putNextEntry(new ZipEntry(dir));
            // 进行写操作
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            // 关闭输入流
            inputStream.close();
        }

    }
    public static File fileLinesWrite(String filePath,String content,boolean flag){
        String filedo = "write";
        FileWriter fw = null;
        File file=null;
        try {
            file=new File(filePath);
            //如果文件夹不存在，则创建文件夹
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            if(!file.exists()){
                //如果文件不存在，则创建文件,写入第一行内容
                file.createNewFile();
                fw = new FileWriter(file);
                filedo = "create";
            }else{
                //如果文件存在,则追加或替换内容
                fw = new FileWriter(file, flag);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    // 测试
    public static void main(String[] args) {
        String path = "D:\\test.test";
        String format = "rar";

        try {
            File file = generateFile(path, format);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}

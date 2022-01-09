package com.sun.yang.maven;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.apache.maven.project.DefaultProjectBuildingRequest;
import org.apache.maven.project.ProjectBuildingRequest;
import org.eclipse.aether.impl.ArtifactResolver;
import org.eclipse.aether.internal.impl.DefaultArtifactResolver;
import org.eclipse.aether.resolution.ArtifactResult;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName MavenTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/18
 **/
public class MavenTest {
    public static void main(String[] args) {
        String url="http://maven.yonyou.com/nexus/repository/iUAP-Stagings/com/yonyou/iuap/yms/iuap-boot-search-starter/2.3.0-RELEASE/iuap-boot-search-starter-2.3.0-RELEASE.jar";
        String savePath="D:/test/iuap-boot-search-starter-2.0.0-RELEASE.jar";
        try {
            downloadFile(url,savePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 文件下载
     * @param fileUrl 下载路径
     * @param savePath 存放地址 示例：D:/ceshi/1.png
     * @throws Exception
     */
    public static void downloadFile(String fileUrl,String savePath) throws Exception {
        File file=new File(savePath);
        //判断文件是否存在，不存在则创建文件
        if(!file.exists()){
            file.createNewFile();
        }
        URL url = new URL(fileUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        DataInputStream in = new DataInputStream(urlCon.getInputStream());
        DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
        byte[] buffer = new byte[2048];
        int count = 0;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        try {
            if(out!=null) {
                out.close();
            }
            if(in!=null) {
                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

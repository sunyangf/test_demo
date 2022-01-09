package com.sun.yang.flt;

import com.yonyou.iuap.yms.alarm.Constant;
import com.yonyou.iuap.yms.alarm.YmsFailureAnalyzers;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @ClassName PropertiesTest
 * @Description TODO
 * @Author Administrator
 * @Date 2022/1/5
 **/
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
//        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResource("event_alarm.properties");
        URL resource = PropertiesTest.class.getClassLoader().getResource("event_alarm.properties");
        InputStream resourceAsStream = PropertiesTest.class.getClassLoader().getResourceAsStream("event_alarm.properties");
        System.out.println(resourceAsStream);
        try {
            properties.load(resourceAsStream);
            String wbmsrkkh = properties.getProperty("wbmsrkkh");
            System.out.println(wbmsrkkh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

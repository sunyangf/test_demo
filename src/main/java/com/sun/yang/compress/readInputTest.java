package com.sun.yang.compress;

import com.yonyou.iuap.yms.alarm.Constant;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/30
 **/
public class readInputTest {


    public static void main(String[] args) {
        String path = "D:/work/iuap-boot-starter-example-flexible/iuap-boot-starter-example-consumer/target/" +
                "iuap-boot-starter-example-consumer-2.2.0-SNAPSHOT-module/WEB-INF/classes/iuap-yms-module/module.xml";
        try (InputStream moduleStream = new FileInputStream(path)) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(moduleStream);
            Element rootElement = document.getRootElement();
            String version = "";
            for (Iterator fathers = rootElement.elementIterator(); fathers.hasNext(); ) {
                Element father = (Element) fathers.next();
                if (father.getQName().getName().equals("external")) {
                    for (Iterator childs = father.elementIterator(); childs.hasNext(); ) {
                        Element child = (Element) childs.next();
                        String fileName = child.attributeValue("fileName");

                    }
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
    }
}
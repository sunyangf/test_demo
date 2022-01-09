package com.sun.yang.javaassist;

import javassist.*;

import java.beans.*;
import java.io.IOException;

/**
 * @ClassName JavaassistTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/19
 **/
public class JavaassistTest {
    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = null;
        try {
            //获取一个Test类的ctclass对象
            ctClass = pool.get("com.sun.yang.javaassist.Test");
            //为ctclasss设置一个父类
            ctClass.setSuperclass(pool.get("com.sun.yang.javaassist.ParentTest"));
            //为cTclass对象添加一个属性name
            ctClass.addField(CtField.make("private String passWord;", ctClass));
            ctClass.addMethod(CtMethod.make("public void setPassWord(String passWord){this.passWord = passWord;}", ctClass));
            ctClass.addMethod(CtMethod.make("public String getPassWord(){return this.passWord;}", ctClass));
            //获取ctClass对象对应的Class对象student
            Class test = ctClass.toClass();
            //对test类进行内省，得到对象BeanInfo
            BeanInfo beanInfo = Introspector.getBeanInfo(test, Object.class);
            //获取beanInfo的方法描述对象
            MethodDescriptor[] descriptors = beanInfo.getMethodDescriptors();
            for (int i = 0; i < descriptors.length; i++) {
                System.out.println(descriptors[i].getName());
            }
            System.out.println(descriptors.length);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                System.out.println(propertyDescriptors[i].getDisplayName());
            }

        } catch (NotFoundException | CannotCompileException  | IntrospectionException e) {
            e.printStackTrace();
        }

    }

}

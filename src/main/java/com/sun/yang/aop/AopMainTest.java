package com.sun.yang.aop;

import com.sun.yang.config.AppConfig;
import com.sun.yang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AopMainTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/31
 **/
public class AopMainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService= applicationContext.getBean(UserService.class);
        userService.print();
    }
}

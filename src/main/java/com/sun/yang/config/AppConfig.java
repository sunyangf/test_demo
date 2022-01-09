package com.sun.yang.config;

import com.sun.yang.aop.MyMethodInterceptor;
import com.sun.yang.service.UserService;
import com.sun.yang.service.impl.UserServiceImpl;
import org.aopalliance.aop.Advice;
import org.checkerframework.checker.units.qual.C;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/31
 **/
@Configuration
public class AppConfig {
    //要创建代理的目标Bean
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    //创建Advice或Advisor
    @Bean
    public Advice myMethodInterceptor(){
        return new MyMethodInterceptor();
    }
    //使用BeanNameAutoProxyCreator来创建代理
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator=new BeanNameAutoProxyCreator();
        //设置要创建代理的那些Bean的名字
        beanNameAutoProxyCreator.setBeanNames("userSer*");
        //设置拦截链名字(这些拦截器是有先后顺序的)
        beanNameAutoProxyCreator.setInterceptorNames("myMethodInterceptor");
        return beanNameAutoProxyCreator;
    }
}

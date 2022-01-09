package com.sun.yang.javaassist;

import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName JavaassistDynDBqueryHandler
 * @Description TODO
 * @Author sy
 * @Date 2021/12/19
 **/
public class JavaassistDynDBqueryHandler implements MethodHandler {
    /**
     * self为由Javassist动态生成的代理类实例，
     *  method为 当前要调用的方法
     *  proceed 为生成的代理类对方法的代理引用。
     *  Object[]为参数值列表，
     * 返回：从代理实例的方法调用返回的值。
     *
     * 其中，proceed.invoke(self, args);
     *
     * 调用代理类实例上的代理方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）
     */
    @Override
    public Object invoke(Object self, Method method, Method proceed, Object[] objects) throws Throwable {
        System.out.println("Javassist动态生成的代理类实例:"+self.getClass());
        System.out.println("当前要调用方法："+method.getName());
        System.out.println("生成的代理类对方法的代理引用"+proceed.getName());
        Arrays.stream(objects).forEach(org-> System.out.println(org));
        Arrays.stream(objects).forEach(System.out::println);
        System.out.println("================javassist proxy before sing");
        Object ret = proceed.invoke(self, objects);
        System.out.println("==============javassist proxy after sing");
        return ret;
    }
}

package com.sun.yang.javaassist;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @ClassName JavassistProxyFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/19
 **/
public class JavassistProxyFactory<T> {
    private T target;

    public void setTarget(T target) {
        this.target = target;
    }
    @SuppressWarnings( "deprecation")
    public T getProxy() throws InstantiationException, IllegalAccessException {
        // 代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置需要创建子类的父类
        proxyFactory.setSuperclass(target.getClass());
        /*
         * 定义一个拦截器。在调用目标方法时，Javassist会回调MethodHandler接口方法拦截，
         * 来实现你自己的代理逻辑，
         * 类似于JDK中的InvocationHandler接口。
         */

        proxyFactory.setHandler(new JavaassistDynDBqueryHandler());
        // 通过字节码技术动态创建子类实例
        return (T) proxyFactory.createClass().newInstance();
    }


}

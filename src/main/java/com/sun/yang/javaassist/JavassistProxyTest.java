package com.sun.yang.javaassist;

import com.sun.yang.javaassist.service.impl.DBQuery;

/**
 * @ClassName JavassistProxyTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/19
 **/
public class JavassistProxyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        JavassistProxyFactory<DBQuery> proxyFactory = new JavassistProxyFactory<DBQuery>();
        DBQuery dbQuery=new DBQuery();
        proxyFactory.setTarget(dbQuery);
        DBQuery proxy = proxyFactory.getProxy();
        proxy.request();
        System.out.println("*******************方式二*******************");
        JavassistProxyFactory02 jpf02 = new JavassistProxyFactory02();
        DBQuery a2 = (DBQuery) jpf02.getProxy(DBQuery.class);
        a2.request();
        a2.say();
    }
}

package com.sun.yang.pool;

import org.apache.commons.pool.PoolableObjectFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class PoolAbleObjectFactoryDemo implements PoolableObjectFactory {
    private static AtomicInteger counter=new AtomicInteger();

    /**
     * 创建对象
     * @return
     * @throws Exception
     */
    @Override
    public Object makeObject() throws Exception {
        Object obj=String.valueOf(counter.getAndDecrement());
        System.out.println("create obj "+obj);
        return obj;
    }

    /**
     * 对象从对象池中销毁时调用
     * @param o
     * @throws Exception
     */
    @Override
    public void destroyObject(Object o) throws Exception {
        System.out.println("Destroy Object "+o);
    }

    /**
     * 判断对象是否可用
     * @param o
     * @return
     */
    @Override
    public boolean validateObject(Object o) {
        return true;
    }

    /**
     * 在取用之前被调用，会激活这个对象
     * @param o
     * @throws Exception
     */
    @Override
    public void activateObject(Object o) throws Exception {
        System.out.println("before borrow " + o);
    }

    /**
     * 对象返回对象池时被调用
     * @param o
     * @throws Exception
     */
    @Override
    public void passivateObject(Object o) throws Exception {
        System.out.println("return "+o);
    }
}

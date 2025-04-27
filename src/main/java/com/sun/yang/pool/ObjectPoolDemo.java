package com.sun.yang.pool;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

public class ObjectPoolDemo {
    static PoolableObjectFactory factory=new PoolAbleObjectFactoryDemo();

    static ObjectPool pool = new GenericObjectPool(factory);

    private static AtomicInteger endcount=new AtomicInteger(0);

    public static class PoolThread extends Thread{

        public void run(){
            Object obj = null;
            try{
                for (int i = 0; i < 100; i++) {
                    System.out.println("--------"+i+"--------------");
                    //从对象池中得到对象

                     obj = pool.borrowObject();
                     //模拟对象的使用
                    System.out.println(obj +"is get");
                    pool.returnObject(obj);
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }finally {
                endcount.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        new PoolThread().start();
        try {
            Thread.sleep(10000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new PoolThread().start();
        try {
            Thread.sleep( 10000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new PoolThread().start();
        try {
            while(true){
                if(endcount.getAndIncrement() == 3){
                    pool.close();
                    break;
                }
            }
        }catch (Exception e){

        }
    }
}

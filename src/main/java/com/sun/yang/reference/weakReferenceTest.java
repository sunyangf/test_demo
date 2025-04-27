package com.sun.yang.reference;

import com.sun.yang.pojo.TestUser;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class weakReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        List<WeakReference> weakReferenceList=new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            WeakReference<Object> weakReference = new WeakReference<>(new TestUser(Math.round(Math.random()*1000)),referenceQueue);
            weakReferenceList.add(weakReference);
        }
        WeakReference weakReference;
        Integer count = 0;
        while ((weakReference= (WeakReference) referenceQueue.poll())!=null){
            System.out.println("被回收的对象是："+weakReference.get());
            count++;
        }
        System.out.println("被回收的对象个数是："+count);
        System.out.println("在不被清理的情况下，可以从weakReference中取出对象值:"+new WeakReference(new TestUser(Math.round(Math.random()*1000)),referenceQueue).get());
    }
}

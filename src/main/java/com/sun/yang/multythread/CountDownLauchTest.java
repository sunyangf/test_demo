package com.sun.yang.multythread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLauchTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch corder=new CountDownLatch(1);
        CountDownLatch answter=new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("选手："+Thread.currentThread().getName()+"等待教练指令");
                        corder.await();
                        System.out.println("选手："+Thread.currentThread().getName()+"接收到教练指令！！");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                        answter.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            executorService.execute(runnable);
        }
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
            corder.countDown();
            System.out.println("裁判"+Thread.currentThread().getName()+"已发送口令，正在等待所有选手到达终点");
            answter.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}

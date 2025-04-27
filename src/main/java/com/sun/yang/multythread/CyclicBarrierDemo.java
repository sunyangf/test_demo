package com.sun.yang.multythread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierDemo {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    //首先定义一个共同执行的的逻辑
    static CyclicBarrier cyclicBarrier=new CyclicBarrier(4, new Runnable() {
        @Override
        public void run() {
            System.out.println("开始串行执行");
        }
    });

    public static class GoThread extends Thread{
        private final String name;
        public GoThread(String name){
            this.name=name;
        }
        @Override
        public void run() {
            System.out.println(name+"从宿舍出发！！");
            try {
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println(name+"从楼底下出发");
                Thread.sleep((long) (Math.random()*10000));
                System.out.println(name+"到达操场");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] str= {"李明","王强","刘凯","赵杰"};
        String[] str1= {"李明1","王强1","刘凯1","赵杰1"};
        for(int i=0;i<4;i++){
            executorService.execute(new GoThread(str[i]));
        }
        try
        {
            Thread.sleep((long) (Math.random()*10000));
            System.out.println("四个人一起到达球场，现在开始打球");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

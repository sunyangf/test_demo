package com.sun.yang.multythread.disruptor.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.sun.yang.multythread.disruptor.dto.Order;
import com.sun.yang.multythread.disruptor.factory.OrderFactory;
import com.sun.yang.multythread.disruptor.handler.OrderHandler;
import com.sun.yang.multythread.disruptor.handler.OrderHandler1;

import java.util.concurrent.Executors;

public class DisruptorTest {
    public static void main(String[] args) throws InterruptedException {
        //创建订单工厂
        OrderFactory orderFactory = new OrderFactory();
        //ringbuffer的大小
        int RINGBUFFER_SIZE = 1;
        //创建disruptor
        Disruptor<Order> disruptor = new Disruptor<Order>(orderFactory,RINGBUFFER_SIZE, Executors.defaultThreadFactory());
        OrderHandler h1 = new OrderHandler();
        OrderHandler h2 = new OrderHandler();
        OrderHandler1 h3 = new OrderHandler1();
        //设置事件处理器 即消费者
        EventHandlerGroup<Order> eventHandlerGroup = disruptor.handleEventsWith(h1,h2);
        eventHandlerGroup.then(h3);
        disruptor.start();
        RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();
        for(int i = 0 ; i < 1 ; i++){
            long sequence = ringBuffer.next();
            Order order = ringBuffer.get(sequence);
            order.setId(i);
            ringBuffer.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }
        Thread.sleep(1000);
        disruptor.shutdown();

    }
}

package com.sun.yang.multythread.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.sun.yang.multythread.disruptor.dto.Order;

public class OrderHandler1 implements EventHandler<Order> {
    @Override
    public void onEvent(Order order, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + " 合并消费者处理中:" + l);
        order.setInfo("info" + order.getId());
        order.setPrice(Math.random());
        System.out.println(order.toString());
    }
}

package com.sun.yang.multythread.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.sun.yang.multythread.disruptor.dto.Order;

public class OrderFactory implements EventFactory {
    @Override
    public Object newInstance() {
        System.out.println("OrderFactory.newInstance");
        return new Order();
    }
}

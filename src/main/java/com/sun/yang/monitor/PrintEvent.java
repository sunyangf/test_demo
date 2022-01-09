package com.sun.yang.monitor;

import java.util.EventObject;

/**
 * @ClassName PrintEvent
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class PrintEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public PrintEvent(Object source) {
        super(source);
    }
    public void doEvent() {
        //getSource The object on which the Event initially occurred.
        System.out.println("通知一个事件源 source: " + this.getSource());
    }
}

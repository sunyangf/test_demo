package com.sun.yang.monitor;

import java.util.EventListener;

/**
 * @ClassName MonitorListener
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public interface MonitorListener extends EventListener {

    public void handleEvent(PrintEvent event);
}

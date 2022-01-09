package com.sun.yang.monitor;

import java.util.Vector;

/**
 * @ClassName EventSource
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class EventSource {
    //监听器列表，如果监听事件源的事件，注册监听器可以加入此列表
    private Vector<MonitorListener> listenerList = new Vector<>();
    //注册监听器
    public void addListener(MonitorListener eventListener) {
        listenerList.add(eventListener);
    }
    //删除监听器
    public void removeListener(MonitorListener eventListener) {
        int i = listenerList.indexOf(eventListener);
        if(i >= 0) {
            listenerList.remove(eventListener);
        }
    }
    //接受外部事件，通知所有的监听器
    public void notifyListenerEvents(PrintEvent event) {
        for(MonitorListener moniterListener : listenerList) {
            moniterListener.handleEvent(event);
        }
    }
    public void addCloseWindowListener(MonitorListener eventListener) {
        System.out.println("关注关闭窗口事件");
        listenerList.add(eventListener);
    }

    public void doCloseWindows() {
        this.notifyListenerEvents(new PrintEvent("closeWindows"));
    }


}

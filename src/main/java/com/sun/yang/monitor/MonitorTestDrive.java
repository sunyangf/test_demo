package com.sun.yang.monitor;

/**
 * @ClassName MonitorTestDrive
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class MonitorTestDrive {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new MonitorListener() {
            @Override
            public void handleEvent(PrintEvent event) {
                event.doEvent();
                if(event.getSource().equals("openWindows")) {
                    System.out.println("doOpen");
                }
                if(event.getSource().equals("closeWindows")){
                    System.out.println("doClose");
                }
            }
        });
        eventSource.notifyListenerEvents(new PrintEvent("openWindows"));
        //第二种方式
        EventSource windows = new EventSource();
        windows.addCloseWindowListener(new MonitorListener() {

            @Override
            public void handleEvent(PrintEvent event) {
                // TODO Auto-generated method stub
                event.doEvent();
                if(event.getSource().equals("closeWindows")) {
                    System.out.println("通过addCloseWindowListener来关注关闭窗口事件，并执行成功"
                            + "closeWindows");
                }
            }
        });

        //窗口关闭动作,现在是不是类似按钮注册监听器，然后点击触发点击事件，执行监听器中对应事件的动作
        windows.doCloseWindows();
    }

}

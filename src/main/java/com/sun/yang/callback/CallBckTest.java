package com.sun.yang.callback;

/**
 * @ClassName CallBckTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/29
 **/
public class CallBckTest {
    public static void main(String[] args) {
        MainBusiness mainBusiness = new MainBusiness();

        System.out.println("*********具体实现类实现的回调方法_固定*********");
        mainBusiness.execute(new CallbackServiceImpl());

        System.out.println("*********匿名内部类实现的回调方法_灵活*********");
        mainBusiness.execute(new CallbackService() {

            @Override
            public void callBackFunc() {
                System.out.println("匿名内部类回调函数开始执行...");
                System.out.println("匿名内部类回调函数结束执行...\n");
            }
        });
    }
}

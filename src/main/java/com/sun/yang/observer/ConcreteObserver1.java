package com.sun.yang.observer;

public class ConcreteObserver1 implements IObserver{
    @Override
    public void update() {
        System.out.println("具体观察者1作出反应！");
    }
}

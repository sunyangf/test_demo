package com.sun.yang.observer;

public class ConcreteObserver2 implements IObserver{
    @Override
    public void update() {
        System.out.println("具体观察者2作出反应！");
    }
}

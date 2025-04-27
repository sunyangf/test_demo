package com.sun.yang.observer;

public class ObserverTest {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcreteObserver1 concreteObserver1 = new ConcreteObserver1();
        ConcreteObserver2 concreteObserver2 = new ConcreteObserver2();
        concreteSubject.attach(concreteObserver1);
        concreteSubject.attach(concreteObserver2);
        concreteSubject.inform();
    }
}

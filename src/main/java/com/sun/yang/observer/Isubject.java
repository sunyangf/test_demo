package com.sun.yang.observer;

/**
 * 被观察者
 */
public interface Isubject {
    void attach(IObserver observer);
    void inform();
}

package com.sun.yang.observer;


import javafx.event.Event;

import java.util.Vector;

public class ConcreteSubject implements Isubject{
    Vector<IObserver> observers=new Vector<>();
    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void inform() {


    }
}

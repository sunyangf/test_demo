package com.sun.yang.visitor;


import com.sun.yang.visitor.service.Visitor;

public abstract  class Staff {

    public String name;

    public double kpi;

    public Staff(String name) {
        this.name = name;
    }

    abstract void accept(Visitor visitor);
}

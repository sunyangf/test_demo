package com.sun.yang.visitor;

import com.sun.yang.visitor.service.Visitor;

public class Manager extends Staff{
    public Manager(String name) {
        super(name);
        this.kpi=Math.random();
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

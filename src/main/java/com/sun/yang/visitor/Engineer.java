package com.sun.yang.visitor;

import com.sun.yang.visitor.service.Visitor;

public class Engineer extends Staff{

    public Engineer(String name) {
        super(name);
        this.kpi = Math.random();
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

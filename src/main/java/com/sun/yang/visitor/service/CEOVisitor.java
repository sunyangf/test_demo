package com.sun.yang.visitor.service;

import com.sun.yang.visitor.Engineer;
import com.sun.yang.visitor.Manager;

public class CEOVisitor implements Visitor{
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师："+engineer.name+" kpi:"+engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("项目经理："+manager.name+" kpi:"+manager.kpi);
    }
}

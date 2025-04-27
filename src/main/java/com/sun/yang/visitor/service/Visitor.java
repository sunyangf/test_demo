package com.sun.yang.visitor.service;

import com.sun.yang.visitor.Engineer;
import com.sun.yang.visitor.Manager;


public interface Visitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}

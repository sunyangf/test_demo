package com.sun.yang.visitor;

import com.sun.yang.visitor.service.CEOVisitor;

public class ClentVisitor {
    public static void main(String[] args) {
        CEOVisitor ceoVisitor = new CEOVisitor();
        ReportFactory reportFactory = new ReportFactory();
        reportFactory.getReport(ceoVisitor);
    }
}

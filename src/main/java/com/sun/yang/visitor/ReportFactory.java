package com.sun.yang.visitor;

import com.sun.yang.visitor.service.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ReportFactory {
    List<Staff> staffs=new ArrayList<>();

    public ReportFactory() {
        staffs.add(new Engineer("1"));
        staffs.add(new Engineer("2"));
        staffs.add(new Manager("3"));
        staffs.add(new Manager("4"));
    }

    public void getReport(Visitor visitor){
        for(Staff staff:staffs){
            staff.accept(visitor);
        }
    }
}

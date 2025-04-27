package com.sun.yang.decorate;

public class SugarDecorator extends CondimentDecorator{
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}

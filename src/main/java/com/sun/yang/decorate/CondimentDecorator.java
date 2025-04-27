package com.sun.yang.decorate;

/**
 * 调味品装饰器
 */
public abstract class CondimentDecorator implements Beverage{
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

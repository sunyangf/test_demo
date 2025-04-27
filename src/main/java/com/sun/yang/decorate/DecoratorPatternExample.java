package com.sun.yang.decorate;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Beverage coffee = new SimpleCoffee();
        System.out.println("原味咖啡价格: " + coffee.cost());
        // 用加糖装饰器装饰咖啡
        Beverage sweetCoffee = new SugarDecorator(coffee);
        System.out.println("加糖咖啡价格: " + sweetCoffee.cost());
    }
}

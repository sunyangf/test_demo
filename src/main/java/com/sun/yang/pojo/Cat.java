package com.sun.yang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author Administrator
 * @Date 2022/1/7
 **/
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false,of = {"color"})
public class Cat extends Animal{
    private int weight;
    private String color;

    public Cat(int id, String name, int weight, String color) {
        super(id, name);
        this.weight = weight;
        this.color = color;
    }
}

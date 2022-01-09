package com.sun.yang.lombok;

import com.sun.yang.pojo.Cat;

/**
 * @ClassName EqualsAndHashCodeTest
 * @Description TODO
 * @Author Administrator
 * @Date 2022/1/7
 **/
public class EqualsAndHashCodeTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat(123, "tom", 20, "红色");
        Cat cat2 = new Cat(456, "tom", 10, "红色");
        System.out.println(cat1.equals(cat2));
    }
}

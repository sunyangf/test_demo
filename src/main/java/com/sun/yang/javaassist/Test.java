package com.sun.yang.javaassist;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/19
 **/
public class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }
}

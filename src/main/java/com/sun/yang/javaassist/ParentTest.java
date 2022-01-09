package com.sun.yang.javaassist;

/**
 * @ClassName ParentTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/19
 **/
public class ParentTest {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ParentTest{" +
                "age=" + age +
                '}';
    }
}

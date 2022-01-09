package com.sun.yang.stream;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/10
 **/
public class Student implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 7544685819102239171L;

    /**
     * 学生编号
     */
    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 个子是否高
     */
    private boolean isHigh;

    /**
     * 学生成绩
     */
    private Double mathScore;

    public Student(int id, String name, boolean isHigh, Double mathScore) {
        this.id = id;
        this.name = name;
        this.isHigh = isHigh;
        this.mathScore = mathScore;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }

    public boolean isHigh() {
        return isHigh;
    }

    public void setHigh(boolean high) {
        isHigh = high;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isHigh=" + isHigh +
                ", mathScore=" + mathScore +
                '}';
    }

}

package com.sun.yang.pojo;

/**
 * @ClassName Data2
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class Data2 extends SuperPO{
    private int id;
    private String name;
    private String type;


    public Data2(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Data2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

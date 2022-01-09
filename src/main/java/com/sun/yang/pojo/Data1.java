package com.sun.yang.pojo;

/**
 * @ClassName Data1
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class Data1 extends SuperPO{
    private int id;
    private String name;
    private int amount;

    public Data1(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Data1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}

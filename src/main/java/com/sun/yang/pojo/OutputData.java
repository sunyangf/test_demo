package com.sun.yang.pojo;

/**
 * @ClassName OutputData
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class OutputData {
    private int id;
    private String name;
    private String type;
    private int amount;

    public OutputData(int id, String name, String type, int amount) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}

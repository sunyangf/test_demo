package com.sun.yang.pojo;

/**
 * @ClassName Aclass
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class Aclass {
    private Integer num;
    private String name;
    private String passWord;

    public Aclass(Integer num, String name, String passWord) {
        this.num = num;
        this.name = name;
        this.passWord = passWord;
    }

    public Aclass(Integer num) {
        this.num = num;
    }
    public String getTTT(String aa,String bb){
        return aa+bb;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Aclass{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

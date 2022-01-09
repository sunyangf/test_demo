package com.sun.yang.pojo;

import java.util.List;

/**
 * @ClassName ListContainer
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class ListContainer {
    private List<Aclass> list;

    public ListContainer(List<Aclass> list) {
        this.list = list;
    }

    public List<Aclass> getList() {
        return list;
    }

    public void setList(List<Aclass> list) {
        this.list = list;
    }
}

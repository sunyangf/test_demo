package com.sun.yang.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ListStreamAddElement
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class ListStreamAddElement {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("test");
        list.add("ceshi");
        String collect = list.stream().collect(Collectors.joining(",", "", "11"));
        System.out.println(collect);

        String collect1 = list.stream().map(str -> str += "11").collect(Collectors.joining(","));
        System.out.println(collect1);
    }
}

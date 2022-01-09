package com.sun.yang.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamMapTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/13
 **/
public class StreamMapTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("test");
        list.add("aaaaa");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
        String collect1 = list.stream().map(String::toString).collect(Collectors.joining(","));
        System.out.println("er:"+collect1);

    }
}

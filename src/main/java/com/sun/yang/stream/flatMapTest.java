package com.sun.yang.stream;

import com.google.common.collect.Lists;
import com.sun.yang.pojo.Aclass;
import com.sun.yang.pojo.ListContainer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName flatMapTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class flatMapTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        System.out.println("---交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);    // 并集
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---并集 listAll---");
        listAll.parallelStream().forEachOrdered(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEachOrdered(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEachOrdered(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEachOrdered(System.out :: println);

    }
}

package com.sun.yang.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @ClassName flatMapToIntTest
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/16
 **/
public class flatMapToIntTest {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("5", "6"),
                Arrays.asList("3", "4")
        );
        IntStream intStream = listOfLists.stream().flatMapToInt(childList -> childList.stream().mapToInt(Integer::new));
        int sum = intStream.peek(System.out::println).sum();
        System.out.println("sum: " + sum);
    }
}

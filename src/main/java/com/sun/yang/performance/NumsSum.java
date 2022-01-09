package com.sun.yang.performance;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName NumsSum
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/21
 **/
public class NumsSum {
    static List<Integer> nums = new ArrayList<>();
    static {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000 + r.nextInt(1000000));
        }
    }
    @Benchmark
    public static void foreach() {
        nums.forEach(v->isPrime(v));
    }

    static void parallel() {
        nums.parallelStream().forEach(NumsSum::isPrime);
    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Options opt = new OptionsBuilder()
                .include(NumsSum.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        try {
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
